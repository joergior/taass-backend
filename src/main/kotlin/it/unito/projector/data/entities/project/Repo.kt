package it.unito.projector.data.entities.project

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Repo(@Id @GeneratedValue val id: Long = 0,
                val tile: String, val link: String,
                val icon: String)