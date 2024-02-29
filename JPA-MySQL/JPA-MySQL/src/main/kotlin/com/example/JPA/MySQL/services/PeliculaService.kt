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
     * Permite crear una pelicula
     * @param tituloPelicula titulo de la pelicula
     * @param idActor id del actor
     * @param idUser id del usuario
     * @param vista 0 -> pelicula no vista, 1 -> pelicula vista
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
        if(idActor!=null)
            peli.protagonista = actorRepository!!.findActorsByIdActor(idActor)
        else
            peli.protagonista = null
        peli.vista = vista
        listaPeliculaRepository!!.save(peli)
        return "Saved"
    }


    /**
     * Devuelve todas las peliculas
     */
    fun getAllFilms(): MutableIterable<Pelicula?> {
        return listaPeliculaRepository!!.findAll()
    }


    /**
     * Devuelve las película por id
     * @param idPelicula id de la pelicula
     */
    fun getFilmsById(idPelicula: Int):Pelicula?{
        return listaPeliculaRepository!!.findPeliculaByIdPelicula(idPelicula)
    }


    /**
     * Obtiene peliculas por titulos
     * @param titulo titulo de la pelicula
     */

    fun getFilmsByTitulo(titulo:String): List<Pelicula>{
        return listaPeliculaRepository!!.findPeliculaByTituloPelicula(titulo)
    }


    /**
     * Obtiene pelicula si la han visto
     * @param vista 0 -> no se ha visto la película, 1 -> se ha visto
     */
    fun getFilmsByVista(vista : Int) : List<Pelicula>{
        return listaPeliculaRepository!!.findPeliculaByVista(vista)
    }

    /**
     * Obtiene pelicula por el id del actor
     * @param idActor id del actor
     */

    fun getFilmsByIdActor(idActor: Int):List<Pelicula>{
        var actor = actorRepository!!.findActorsByIdActor(idActor)
        return listaPeliculaRepository!!.findPeliculaByProtagonista(actor)
    }

    /**
     * Obtiene pelicula por el nombre del actor
     * @param nombreActor nombre del actor
     */
    fun getFilmsByNombreActor(nombreActor: String):List<Pelicula>{
        var actor = actorRepository!!.findActorsByNombreActor(nombreActor).first()
        return listaPeliculaRepository!!.findPeliculaByProtagonista(actor)
    }


    /**
     * Elimina la pelicula por nombre de pelicula
     * @param nombre nombre de la pelicula que deseas borrar
     * @return mensaje de ha sido borrada o no
     */
    fun deleteByFilm(nombre: String):String{
        if(nombre.isEmpty()){
            return "pelicula no encontrada"
        }else{
            var film = listaPeliculaRepository!!.findPeliculaByTituloPelicula(nombre).first()
            listaPeliculaRepository.delete(film)
            return "Pelicula borrada $nombre"
        }
    }


    /**
     * actualiza el nombre de la pelicula
     * @param nombreAntiguo nombre antiguo de la pelicula
     * @param nombreNuevo nombre nuevo de la pelicula
     */
    fun updateFilmsByNombre(nombreAntiguo: String, nombreNuevo:String):String{
        if(nombreAntiguo.isEmpty()){
            return "pelicula no encontrada"
        }else{
            var film = listaPeliculaRepository!!.findPeliculaByTituloPelicula(nombreAntiguo).first()
            film.tituloPelicula = nombreNuevo
            listaPeliculaRepository.save(film)
            return "Pelicula actualizada de $nombreAntiguo a $nombreNuevo"
        }
    }



}