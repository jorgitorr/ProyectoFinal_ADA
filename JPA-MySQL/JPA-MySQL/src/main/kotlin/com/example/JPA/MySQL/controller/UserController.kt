package com.example.JPA.MySQL.controller

import com.example.JPA.MySQL.data.Lista
import com.example.JPA.MySQL.data.Pelicula
import com.example.JPA.MySQL.data.User
import com.example.JPA.MySQL.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller // This means that this class is a Controller
@RequestMapping(path=["/user"]) // This means URL's start with /demo (after Application path)
class UserController {
    @Autowired

    private val listaUsuariosRepository: UserRepository? = null


    @PostMapping(path=["/add"]) // Map ONLY POST Requests
    @ResponseBody
    fun addNewUser(
            @RequestParam nombreUser: String?
    ): String {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        val n = User()
        n.nombreUser = nombreUser
        listaUsuariosRepository!!.save(n)
        return "Saved"
    }


    @GetMapping("/all")
    @ResponseBody
    fun getAllUsers(): Iterable<User?> {
        return listaUsuariosRepository!!.findAll()
    }

    @GetMapping("/el_primero")
    @ResponseBody
    fun getUsersByName(@RequestParam nombreUser: String?): Iterable<User?> {
        return if (nombreUser.isNullOrEmpty()) {
            listaUsuariosRepository!!.findAll()
        } else {
            listaUsuariosRepository!!.findByNombreUser(nombreUser)
        }
    }


    @GetMapping("/anadeLista")
    fun anadirLista(@RequestParam nombreUser: String?, @RequestParam nombreLista: String?){
        if(nombreUser!!.isNotEmpty()){
            val usuario = listaUsuariosRepository!!.findByNombreUser(nombreUser).first()
            var nuevaLista = Lista()
            nuevaLista.nombre = nombreLista
            usuario!!.listas.add(nuevaLista)
        }
    }

    @GetMapping("/buscaLista")
    fun buscaLista(@RequestParam nombreUser:String?, @RequestParam nombreLista:String?):MutableList<Lista>?{
        var listaBuscada:MutableList<Lista>?=null
        if(nombreLista!!.isNotEmpty()){
            val usuario = listaUsuariosRepository!!.findByNombreUser(nombreUser!!).first()
            listaBuscada = usuario!!.listas
        }
        return listaBuscada
    }


    @GetMapping("/anadePeliculaXLista")
    fun anadirPeliculaXLista(@RequestParam nombreUser: String?, @RequestParam nombreLista:String,
                             @RequestParam nombrePelicula: String?,
                             @RequestParam vista: Boolean, @RequestParam nombreActor:String){
        if(nombreUser.isNullOrEmpty()){

        }else{
            val list = buscaLista(nombreUser,nombreLista)
            //añade pelicula
            val pelicula = Pelicula()
            pelicula.tituloPelicula = nombrePelicula
            pelicula.vista = vista
            //añade actor
            pelicula.protagonista!!.nombreActor = nombreActor
            list!![0].peliculas.add(pelicula)
        }
    }
}