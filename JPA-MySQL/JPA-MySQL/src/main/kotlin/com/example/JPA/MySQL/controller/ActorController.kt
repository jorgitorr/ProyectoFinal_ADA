package com.example.JPA.MySQL.controller

import com.example.JPA.MySQL.data.Actor
import com.example.JPA.MySQL.data.Pelicula
import com.example.JPA.MySQL.services.ActorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller // This means that this class is a Controller
@RequestMapping(path=["/actor"])
class ActorController {
    @Autowired
    private val actorService: ActorService?= null

    @PostMapping(path=["/add"]) // Map ONLY POST Requests
    @ResponseBody
    fun addNewActor(
            @RequestParam nombreActor: String?
    ): String {
        return actorService!!.addNewActor(nombreActor)
    }


    @GetMapping("/all")
    @ResponseBody
    fun getAllActors(): MutableIterable<Actor?> {
        return actorService!!.getAllActors()
    }


    @GetMapping("/busca_por_id")
    @ResponseBody
    fun getFilmsById(@RequestParam idActor: Int): Actor?{
        return actorService!!.getActorById(idActor)
    }



    @GetMapping("/busca_por_nombre")
    @ResponseBody
    fun getActorByNombreActor(@RequestParam nombreActor: String): List<Actor>{
        return actorService!!.getActorByNombreActor(nombreActor)
    }


    @GetMapping("/busca_por_nombre_pelicula")
    @ResponseBody
    fun getActorByFilm(@RequestParam nombrePelicula:String):Actor{
        return actorService!!.getActorByFilm(nombrePelicula)
    }
}