package com.example.JPA.MySQL.services

import com.example.JPA.MySQL.data.Pelicula
import com.example.JPA.MySQL.repository.ActorRepository
import com.example.JPA.MySQL.repository.PeliculaRepository
import com.example.JPA.MySQL.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service
class PeliculaService {

    @Autowired
    private val listaPeliculaRepository: PeliculaRepository? = null
    @Autowired
    private val userRepository: UserRepository ?= null
    @Autowired
    private val actorRepository: ActorRepository ?= null



    /**
     * constructor sobreescrito
     * para poder crear una pelicula con un id de Actor y un idUser
     */
    fun addNewFilm(
            tituloPelicula: String,
            idActor: Int,
            idUser:Int,
            vista:Int
    ): String {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        val peli = Pelicula()
        peli.tituloPelicula = tituloPelicula
        peli.fecha = LocalDateTime.now()
        peli.usuario = userRepository!!.findUserByIdUser(idUser)
        peli.protagonista = actorRepository!!.findActorsByIdActor(idActor)
        peli.vista = vista
        listaPeliculaRepository!!.save(peli)
        return "Saved"
    }


    fun getAllFilms(): MutableIterable<Pelicula?> {
        return listaPeliculaRepository!!.findAll()
    }


    fun getFilmsById(idPelicula: Int):Pelicula?{
        return listaPeliculaRepository!!.findPeliculaByIdPelicula(idPelicula)
    }


    fun getFilmsByTitulo(titulo:String): List<Pelicula>{
        return listaPeliculaRepository!!.findPeliculaByTituloPelicula(titulo)
    }


    fun getFilmsByVista(vista : Int) : List<Pelicula>{
        return listaPeliculaRepository!!.findPeliculaByVista(vista)
    }
}