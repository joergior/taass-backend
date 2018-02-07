package it.unito.projector

import it.unito.projector.data.repositories.*
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ProjectorApplication

fun main(args: Array<String>) {
    SpringApplication.run(ProjectorApplication::class.java, *args)
}

@Bean
fun init(projectRepo: ProjectRepository, repoRepo: RepoRepository, keyRepo: KeynoteRepository): ApplicationRunner? {
    var i = 0

    while (i < 15 ){
        i++

    }
    return null
}
