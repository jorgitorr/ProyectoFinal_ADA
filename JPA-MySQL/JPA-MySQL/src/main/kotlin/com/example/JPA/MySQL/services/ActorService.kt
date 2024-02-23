package com.example.JPA.MySQL.services

import com.example.JPA.MySQL.data.Actor
import com.example.JPA.MySQL.repository.ActorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ActorService {
    @Autowired
    private val actorRepository: ActorRepository ?= null
    fun addNewActor(
            nombreActor: String?
    ): String {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        val a = Actor()
        a.nombreActor = nombreActor
        actorRepository!!.save(a)
        return "Saved"
    }

    fun getAllActors(): MutableIterable<Actor?> {
        return actorRepository!!.findAll()
    }


    fun getActorById(idActor: Int): Actor?{
        return actorRepository!!.findActorsByIdActor(idActor)
    }


    fun getActorByNombreActor(nombreActor: String): List<Actor>{
        return actorRepository!!.findActorsByNombreActor(nombreActor)
    }
}