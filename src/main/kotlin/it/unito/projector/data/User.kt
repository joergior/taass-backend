package it.unito.projector.data

import javax.persistence.Id

data class User(@Id val id: String, var badgeNumber: String, var projectId: Long?)