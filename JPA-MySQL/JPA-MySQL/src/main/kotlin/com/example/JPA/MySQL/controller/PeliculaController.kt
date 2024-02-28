package com.example.JPA.MySQL.controller

import com.example.JPA.MySQL.data.Pelicula
import com.example.JPA.MySQL.data.User
import com.example.JPA.MySQL.repository.PeliculaRepository
import com.example.JPA.MySQL.repository.UserRepository
import com.example.JPA.MySQL.services.PeliculaService
import org.aspectj.weaver.tools.cache.SimpleCacheFactory.path
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime


@Controller // This means that this class is a Controller
@RequestMapping(path=["/pelicula"])
class PeliculaController {
    @Autowired
    private val peliculaService: PeliculaService ?= null

    @PostMapping(path=["/add"]) // Map ONLY POST Requests
    @ResponseBody
    fun addFilm(@RequestParam tituloPelicula:String, idActor: Int, idUser: Int, vista: Int):String{
        return peliculaService!!.addNewFilm(tituloPelicula, idActor, idUser, vista)
    }

    @GetMapping(path=["/all"]) // Map ONLY POST Requests
    @ResponseBody
    fun getAllFilms():MutableIterable<Pelicula?>{
        return peliculaService!!.getAllFilms()
    }


    @GetMapping("/busca_por_id")
    @ResponseBody
    fun getFilmById(idPelicula: Int): Pelicula?{
        return peliculaService!!.getFilmsById(idPelicula)
    }

    @GetMapping(path=["/busca_por_titulo"]) // Map ONLY POST Requests
    @ResponseBody
    fun getFilmsByTitulo(@RequestParam tituloPelicula: String):List<Pelicula>{
        return peliculaService!!.getFilmsByTitulo(tituloPelicula)
    }

    @GetMapping(path=["/busca_por_vista"]) // Map ONLY POST Requests
    @ResponseBody
    fun getFilmsByVista(@RequestParam vista:Int):List<Pelicula>{
        return peliculaService!!.getFilmsByVista(vista)
    }


    @GetMapping(path=["/busca_por_id_actor"]) // Map ONLY POST Requests
    @ResponseBody
    fun getFilmsByActor(@RequestParam idActor: Int):List<Pelicula>{
        return peliculaService!!.getFilmsByIdActor(idActor)
    }


    @GetMapping(path=["/busca_por_nombre_actor"]) // Map ONLY POST Requests
    @ResponseBody
    fun getFilmsByActor(@RequestParam nombreActor: String):List<Pelicula>{
        return peliculaService!!.getFilmsByNombreActor(nombreActor)
    }
}