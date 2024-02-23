package com.example.JPA.MySQL.repository

import com.example.JPA.MySQL.data.Actor
import org.springframework.data.repository.CrudRepository

interface ActorRepository: CrudRepository<Actor?, Int?> {
    fun findActorsByNombreActor(nombreActor:String): List<Actor>

    fun findActorsByIdActor(idActor: Int):Actor
}