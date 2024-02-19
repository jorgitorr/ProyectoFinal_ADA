package com.example.JPA.MySQL.controller

import com.example.JPA.MySQL.data.Lista
import com.example.JPA.MySQL.repository.PeliculaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller // This means that this class is a Controller
@RequestMapping(path=["/lista"]) // This means URL's start with /demo (after Application path)
class ListaController {
    @Autowired
    private val listaPeliculasRepository: PeliculaRepository?=null

    @GetMapping("/anadePelicula")
    fun anadePelicula(@RequestParam nombre:String){

    }
}