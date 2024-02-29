package com.example.JPA.MySQL.services

import com.example.JPA.MySQL.data.Actor
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

    /**
     * Permite agregar un actor
     * @param nombreActor nombre del actor
     */
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

    /**
     * Devuelve todos los actores
     */
    fun getAllActors(): MutableIterable<Actor?> {
        return actorRepository!!.findAll()
    }


    /**
     * Devuelve el actor por id
     * @param idActor id del actor
     */
    fun getActorById(idActor: Int): Actor?{
        return actorRepository!!.findActorsByIdActor(idActor)
    }


    /**
     * Devuelve actor por el nombre
     * @param nombreActor nombre del actor
     */
    fun getActorByNombreActor(nombreActor: String): List<Actor>{
        return actorRepository!!.findActorsByNombreActor(nombreActor)
    }

    /**
     * Devuelve actor por la pelicula
     * @param nombrePelicula nombre de la pelicula
     * @return mensaje de borrado
     */
    fun getActorByFilm(nombrePelicula: String):Actor{
        var pelicula = peliculaRepository!!.findPeliculaByTituloPelicula(nombrePelicula).first()
        return pelicula.protagonista!!
    }


    /**
     * actualiza el actor con un nombre nuevo
     * @param nombreAntiguo nombre antiguo del actor
     * @param nombreNuevo nombre nuevo del actor
     * @return mensaje de borrado
     */
    fun updateActorByNombre(nombreAntiguo: String, nombreNuevo:String):String{
        var actor = actorRepository!!.findActorsByNombreActor(nombreAntiguo).first()
        if(nombreAntiguo.isNullOrEmpty()){
            return "No se ha encontrado nombre del actor"
        }else{
            actor.nombreActor = nombreNuevo
            actorRepository.save(actor)//se guarda el actor
            return "Se ha actualizado el nombre del actor"
        }
    }

    /**
     * borra el actor de la base de datos
     * @param nombreActor nombre del actor
     * @return mensaje de borrado
     */
    fun deleteActorByNombre(nombreActor: String):String{
        var actor = actorRepository!!.findActorsByNombreActor(nombreActor).first()
        if(nombreActor.isNullOrEmpty()){
            return "El nombre del actor es erroneo o vacío"
        }else{
            actorRepository.delete(actor)
            return "Actor Borrado"
        }
    }
}