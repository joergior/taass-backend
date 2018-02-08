package it.unito.projector.data.entities.project

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Keynote(val tile: String, val link: String, val icon: String,
                   @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0)