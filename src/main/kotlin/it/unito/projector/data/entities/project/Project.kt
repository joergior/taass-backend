package it.unito.projector.data.entities.project

import javax.persistence.*

@Entity
data class Project(var title: String, var description: String,
                   @ElementCollection var ownerIds: MutableList<String>? = ArrayList(),
                   @ElementCollection var repoIds: MutableList<Long>? = ArrayList(),
                   @ElementCollection var keynoteIds: MutableList<Long>? = ArrayList(),
                   @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0){

    fun addOwner(id: String) {
        if(id !in ownerIds!!) ownerIds!!.add(id)
    }

    fun addRepo(id: Long){
        if(id !in repoIds!!) repoIds!!.add(id)
    }

    fun addKeynote(id: Long){
        if(id !in keynoteIds!!) keynoteIds!!.add(id)
    }

    fun addOwners(ids: MutableList<String>){
        ids.forEach{addOwner(it)}
    }

    fun addRepos(ids: MutableList<Repo>){
        ids.forEach{addRepo(it.id)}
    }

    fun addKeynotes(ids: MutableList<Keynote>){
        ids.forEach{addKeynote(it.id)}
    }

    override fun toString(): String {
        return "Project:\n" +
                "ID: " + id +" | Title: " + title + "\n" +
                "Description: " + description.substring(0, Math.min(description.length, 15)) + "\n" +
                "ownerIds: " + ownerIds + "\n" +
                "repoIds: " + repoIds +"\n" +
                "keynoteIds: " + keynoteIds
    }
}