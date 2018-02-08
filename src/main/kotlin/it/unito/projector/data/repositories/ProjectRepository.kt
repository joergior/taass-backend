package it.unito.projector.data.repositories

import it.unito.projector.data.entities.project.Keynote
import it.unito.projector.data.entities.project.Project
import it.unito.projector.data.entities.project.Repo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface ProjectRepository : JpaRepository<Project, Long> {
    fun findByTitleContaining(@Param("title") title: String): List<Project>
}

@RepositoryRestResource
interface RepoRepository : JpaRepository<Repo, Long>

@RepositoryRestResource
interface KeynoteRepository : JpaRepository<Keynote, Long>

