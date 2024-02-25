package com.example.JPA.MySQL.services

import com.example.JPA.MySQL.data.User
import com.example.JPA.MySQL.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService  {
    @Autowired
    private val userRepository: UserRepository ?= null

    fun addNewUser(
            nombreUser: String?
    ): String {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        val n = User()
        n.nombreUser = nombreUser
        userRepository!!.save(n)
        return "Saved"
    }


    fun getAllUsers(): Iterable<User?> {
        return userRepository!!.findAll()
    }

    fun getUsersByName(nombreUser: String?): Iterable<User?> {
        return if (nombreUser.isNullOrEmpty()) {
            userRepository!!.findAll()
        } else {
            userRepository!!.findUserByNombreUser(nombreUser)
        }
    }


    fun getUsersById(idUser: Int?): User {
        return if (idUser == null) {
            User()
        } else {
            userRepository!!.findUserByIdUser(idUser)
        }
    }

    fun deleteUserByNombreUser(nombreUser: String?):String{
        var usuario = getUsersByName(nombreUser).first()
        if(nombreUser.isNullOrEmpty()){
            return "No se encontró el usuario"
        }else{
            userRepository!!.delete(usuario!!)
            return "Usuario borrado"
        }
    }


    fun updateUserByNombreUser(nombreUser: String?,nombreNuevo:String?):String{
        var usuario = getUsersByName(nombreUser).first()
        if(nombreUser.isNullOrEmpty()){
            return "No se encontró el usuario"
        }else{
            usuario?.nombreUser = nombreNuevo
            userRepository!!.save(usuario!!)
            return "Usuario modificado"
        }
    }
}