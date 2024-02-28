package com.example.JPA.MySQL.services

import com.example.JPA.MySQL.data.Actor
import com.example.JPA.MySQL.data.Pelicula
import com.example.JPA.MySQL.repository.ActorRepository
import com.example.JPA.MySQL.repository.PeliculaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ActorService {
    @Autowired
    private val actorRepository: ActorRepository ?= null

    @Autowired
    private val peliculaRepository: PeliculaRepository?= null
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

    fun getActorByFilm(nombrePelicula: String):Actor{
        var pelicula = peliculaRepository!!.findPeliculaByTituloPelicula(nombrePelicula).first()
        return pelicula.protagonista!!
    }
}