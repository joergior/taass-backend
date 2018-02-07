package it.unito.projector.data.entities.project

import javax.persistence.*

@Entity
data class Project(var title: String, var description: String,
                   @ElementCollection var ownerIds: ArrayList<Long>? = ArrayList(),
                   @ElementCollection var repoIds: ArrayList<Long>? = ArrayList(),
                   @ElementCollection var keynoteIds: ArrayList<Long>? = ArrayList(),
                   @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0){
    fun addOwner(id: Long) {
        if(id !in ownerIds!!) ownerIds!!.add(id)
    }

    fun addRepo(id: Long){
        if(id !in repoIds!!) repoIds!!.add(id)
    }

    fun addKeynote(id: Long){
        if(id !in keynoteIds!!) keynoteIds!!.add(id)
    }
}