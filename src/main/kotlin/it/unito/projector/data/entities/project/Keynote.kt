package it.unito.projector.data.entities.project

import javax.persistence.GeneratedValue
import javax.persistence.Id

data class Keynote(@Id @GeneratedValue val id: Long = 0,
                   val tile: String, val link: String,
                   val icon: String)