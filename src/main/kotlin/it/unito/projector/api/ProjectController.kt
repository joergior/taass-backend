package it.unito.projector.api

import com.google.gson.Gson
import it.unito.projector.data.entities.project.Project
import it.unito.projector.data.repositories.ProjectRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/projects")
class ProjectController (val repository: ProjectRepository) {

    @PostMapping("create")
    fun createProject(@RequestBody project: String){
        System.out.println(project)
        val p: Project = Gson().fromJson(project, Project::class.java)
        System.out.println(p.toString())

    }
}