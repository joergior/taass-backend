package it.unito.projector.data.repositories

import it.unito.projector.data.entities.project.Keynote
import it.unito.projector.data.entities.project.Project
import it.unito.projector.data.entities.project.Repo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface ProjectRepository : JpaRepository<Project, Long> {
    fun findByTitle(projectTitle: String): List<Project>
}

@RepositoryRestResource
interface RepoRepository : JpaRepository<Repo, Long>

@RepositoryRestResource
interface KeynoteRepository : JpaRepository<Keynote, Long>

