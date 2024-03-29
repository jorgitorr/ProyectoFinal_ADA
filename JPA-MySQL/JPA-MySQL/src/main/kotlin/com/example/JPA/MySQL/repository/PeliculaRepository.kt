package com.example.JPA.MySQL.repository

import com.example.JPA.MySQL.data.Actor
import com.example.JPA.MySQL.data.Pelicula
import com.example.JPA.MySQL.data.User
import org.springframework.data.repository.CrudRepository

interface PeliculaRepository: CrudRepository<Pelicula?, Int?> {


    fun findPeliculaByIdPelicula(idPelicula: Int):Pelicula?
    fun findPeliculaByTituloPelicula(tituloPelicula:String):List<Pelicula>

    fun findPeliculaByVista(vista:Int):List<Pelicula>

    fun findPeliculaByProtagonista(actor:Actor):List<Pelicula>

    fun findPeliculaByUsuario(usuario: User):List<Pelicula>
}