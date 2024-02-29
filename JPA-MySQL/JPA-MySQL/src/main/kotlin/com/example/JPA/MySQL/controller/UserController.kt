package com.example.JPA.MySQL.controller

import com.example.JPA.MySQL.data.Pelicula
import com.example.JPA.MySQL.data.User
import com.example.JPA.MySQL.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller // This means that this class is a Controller
@RequestMapping(path=["/user"]) // This means URL's start with /demo (after Application path)
class UserController {
    @Autowired
    private val userService: UserService ?= null



    @PostMapping(path=["/add"]) // Map ONLY POST Requests
    @ResponseBody
    fun addNewUser(
            @RequestParam nombreUser: String?
    ): String {
        return userService!!.addNewUser(nombreUser)
    }



    @GetMapping("/all")
    @ResponseBody
    fun getAllUsers(): Iterable<User?> {
        return userService!!.getAllUsers()
    }

    @GetMapping("/busca_por_nombre")
    @ResponseBody
    fun getUsersByName(@RequestParam nombreUser: String?): Iterable<User?> {
        return userService!!.getUsersByName(nombreUser)
    }


    @GetMapping("/busca_por_id")
    @ResponseBody
    fun getUsersById(@RequestParam idUser: Int?): User?{
        return userService!!.getUsersById(idUser)
    }

    //me fallo no sé por qué
    @GetMapping("/delete")
    @ResponseBody
    fun deleteUserByNombreUser(@RequestParam nombreUser: String?):String{
        return userService!!.deleteUserByNombreUser(nombreUser)
    }

    //me falla no sé por qué
    @GetMapping("/update")
    @ResponseBody
    fun updateUserByNombreUser(@RequestParam nombreUser: String?, @RequestParam nombreNuevo:String):String{
        return userService!!.updateUserByNombreUser(nombreUser,nombreNuevo)
    }



    @GetMapping("/films_by_user")
    @ResponseBody
    fun getFilmsByNombreUser(@RequestParam nombreUser: String): Iterable<Pelicula?> {
        return userService!!.getFilmsByUser(nombreUser)
    }
}