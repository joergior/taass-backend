package it.unito.projector.data.repositories

import it.unito.projector.ProjectorApplication
import it.unito.projector.data.entities.project.Keynote
import it.unito.projector.data.entities.project.Project
import it.unito.projector.data.entities.project.Repo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.web.bind.annotation.CrossOrigin

@RepositoryRestResource
@CrossOrigin(ProjectorApplication.BACKEND_URL)
interface ProjectRepository : JpaRepository<Project, Long> {
    @Suppress("unused")
    fun findByTitleContainingIgnoreCase(@Param("title") title: String): List<Project>
}

@RepositoryRestResource
@CrossOrigin(ProjectorApplication.BACKEND_URL)
interface RepoRepository : JpaRepository<Repo, Long>{
    @Suppress("unused")
    fun findByTitleContainingIgnoreCase(@Param("title") title: String): List<Repo>
}

@RepositoryRestResource
@CrossOrigin(ProjectorApplication.BACKEND_URL)
interface KeynoteRepository : JpaRepository<Keynote, Long>{
    @Suppress("unused")
    fun findByTitleContainingIgnoreCase(@Param("title") title: String): List<Keynote>
}