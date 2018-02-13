package it.unito.projector

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.core.Ordered
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import java.util.*

@EnableResourceServer
@SpringBootApplication
class ProjectorApplication {

    companion object {

        const val FRONTEND_URL  = "http://localhost:1337"

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(ProjectorApplication::class.java, *args)
        }
    }

    @Bean
    fun simpleCorsFilter(): FilterRegistrationBean {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.allowedOrigins = Collections.singletonList(FRONTEND_URL)
        config.allowedMethods = Collections.singletonList("*")
        config.allowedHeaders = Collections.singletonList("*")
        source.registerCorsConfiguration("/**", config)
        val bean = FilterRegistrationBean(CorsFilter(source))
        bean.order = Ordered.HIGHEST_PRECEDENCE
        return bean
    }
}
