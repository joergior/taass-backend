package it.unito.projector.data.entities.project

import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Project(@Id @GeneratedValue val id: Long = 0,
                   var title: String,
                   var description: String,
                   @ElementCollection var ownerIds: ArrayList<Long>? = ArrayList(),
                   @ElementCollection var repoIds: ArrayList<Long>? = ArrayList(),
                   @ElementCollection var keynoteIds: ArrayList<Long>? = ArrayList()){
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