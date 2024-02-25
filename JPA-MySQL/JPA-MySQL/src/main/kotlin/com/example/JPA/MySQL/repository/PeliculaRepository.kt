package com.example.JPA.MySQL.repository

import com.example.JPA.MySQL.data.Pelicula
import org.springframework.data.repository.CrudRepository

interface PeliculaRepository: CrudRepository<Pelicula?, Int?> {


    fun findPeliculaByIdPelicula(idPelicula: Int):Pelicula?
    fun findPeliculaByTituloPelicula(tituloPelicula:String):List<Pelicula>

    fun findPeliculaByVista(vista:Int):List<Pelicula>

}