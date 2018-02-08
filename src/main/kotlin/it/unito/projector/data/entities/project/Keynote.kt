package it.unito.projector.data.entities.project

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Keynote(var title: String, var link: String, var icon: String,
                   @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0)