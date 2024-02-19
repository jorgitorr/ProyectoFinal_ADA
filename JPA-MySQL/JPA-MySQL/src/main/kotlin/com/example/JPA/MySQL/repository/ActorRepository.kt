package com.example.JPA.MySQL.repository

import com.example.JPA.MySQL.data.Actor
import com.example.JPA.MySQL.data.Lista
import com.example.JPA.MySQL.data.Pelicula
import com.example.JPA.MySQL.data.User
import org.springframework.data.repository.CrudRepository

interface ActorRepository: CrudRepository<Actor?, Int?> {
    fun findByNombreActor(nombreActor:String): List<Pelicula>
}