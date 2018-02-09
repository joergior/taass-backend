package it.unito.projector.data.repositories

import it.unito.projector.ProjectorApplication
import it.unito.projector.data.entities.project.Keynote
import it.unito.projector.data.entities.project.Project
import it.unito.projector.data.entities.project.Repo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.web.bind.annotation.CrossOrigin

@EnableResourceServer
@RepositoryRestResource
@CrossOrigin(ProjectorApplication.FRONTEND_URL)
interface ProjectRepository : JpaRepository<Project, Long> {
    @Suppress("unused")
    fun findByTitleContainingIgnoreCase(@Param("title") title: String): List<Project>
}

@EnableResourceServer
@RepositoryRestResource
@CrossOrigin(ProjectorApplication.FRONTEND_URL)
interface RepoRepository : JpaRepository<Repo, Long>{
    @Suppress("unused")
    fun findByTitleContainingIgnoreCase(@Param("title") title: String): List<Repo>
}

@EnableResourceServer
@RepositoryRestResource
@CrossOrigin(ProjectorApplication.FRONTEND_URL)
interface KeynoteRepository : JpaRepository<Keynote, Long>{
    @Suppress("unused")
    fun findByTitleContainingIgnoreCase(@Param("title") title: String): List<Keynote>
}