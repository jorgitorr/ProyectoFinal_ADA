package com.example.JPA.MySQL.repository

import com.example.JPA.MySQL.data.Lista
import com.example.JPA.MySQL.data.Pelicula
import org.springframework.data.repository.CrudRepository

interface PeliculaRepository: CrudRepository<Pelicula?, Int?> {
    fun findBytituloPelicula(titulo:String):List<Pelicula>
    fun findByvista(Vista:Boolean):List<Pelicula>
}