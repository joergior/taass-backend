package it.unito.projector

import it.unito.projector.data.repositories.*
import it.unito.projector.data.entities.project.*
import org.springframework.boot.CommandLineRunner
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
    fun init(projectRepo: ProjectRepository, repoRepo: RepoRepository, keyRepo: KeynoteRepository) = CommandLineRunner {
        var i = 0
        repoRepo.save(Repo("Repo 1", "http://repo1", "github"))
        repoRepo.save(Repo("Repo 2", "http://repo2", "git"))
        repoRepo.save(Repo("Repo 3", "http://repo3", "bitbucket"))
        keyRepo.save(Keynote("Keynote 1", "http://keynote1", "presentation"))
        keyRepo.save(Keynote("Keynote 2", "http://keynote2", "presentation"))
        keyRepo.save(Keynote("Keynote 3", "http://keynote3", "presentation"))
        while(i < 15){
            i++
            val p = Project("Projector $i", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse dapibus," +
                    " ante et ultrices aliquam, felis risus mattis eros, id molestie.")
            p.addKeynotes(keyRepo.findAll())
            p.addRepos(repoRepo.findAll())
            p.addOwner("Lamberto Basti")
            projectRepo.save(p)
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
