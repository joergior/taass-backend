package it.unito.projector.api

import com.okta.sdk.authc.credentials.TokenClientCredentials
import com.okta.sdk.client.Client
import com.okta.sdk.client.Clients
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.utils.URIBuilder
import org.apache.http.impl.client.HttpClients
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.web.bind.annotation.*
import org.apache.http.impl.client.BasicResponseHandler
import org.apache.http.impl.client.CloseableHttpClient
import java.net.URI


@EnableResourceServer
@RestController
@RequestMapping("api/users")
class UserController(val token: String = "00q2WxnFvDXrI5-YThuAMySprvL3JwFM4B7uem6u5N",
                     val client: Client = Clients.builder()
                                .setClientCredentials(TokenClientCredentials(token))
                                .setOrgUrl("https://dev-928137-admin.oktapreview.com").build(),
                     val clientId: String = "0oadx8g38e3bAet2I0h7",
                     val httpClient: CloseableHttpClient? = HttpClients.createDefault()) {

    private fun buildUserURI(userId: String): URI {
        return URIBuilder()
                .setScheme("http")
                .setHost("dev-928137-admin.oktapreview.com")
                .setPath("/api/v1/apps/$clientId/users/$userId")
                .build()
    }

    @GetMapping("me")
    @ResponseBody
    fun getCurrentUser(principal: OAuth2Authentication): String {
        val userId = client.getUser(principal.name).id
        val uri = buildUserURI(userId)
        val get = HttpGet(uri)
        get.addHeader("Authorization", "SSWS " + token)
        val response = httpClient!!.execute(get)
        val respString = BasicResponseHandler().handleResponse(response)
        response.close()
        return respString
    }

    @GetMapping("/email/{email}")
    @ResponseBody
    fun getUserByEmail(@PathVariable("email") email: String): String {
        val uri = buildUserURI(client.getUser(email).id)
        val get = HttpGet(uri)
        get.addHeader("Authorization", "SSWS " + token)
        val response = httpClient!!.execute(get)
        val respString = BasicResponseHandler().handleResponse(response)
        response.close()
        return respString
    }

    @GetMapping("{id}")
    @ResponseBody
    fun getUserByID(@PathVariable("id") userId: String): String {
        val uri = buildUserURI(userId)
        val get = HttpGet(uri)
        get.addHeader("Authorization", "SSWS " + token)
        val response = httpClient!!.execute(get)
        val respString = BasicResponseHandler().handleResponse(response)
        response.close()
        return respString
    }
}