package it.unito.projector

import it.unito.projector.data.repositories.*
import it.unito.projector.data.entities.project.*
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ProjectorApplication {
    companion object {
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
        keyRepo.save(Keynote("Keynote 1", "http://keynote1", "keynote"))
        keyRepo.save(Keynote("Keynote 2", "http://keynote2", "keynote"))
        keyRepo.save(Keynote("Keynote 3", "http://keynote3", "keynote"))
        while(i < 15){
            i++

        }
    }
}
