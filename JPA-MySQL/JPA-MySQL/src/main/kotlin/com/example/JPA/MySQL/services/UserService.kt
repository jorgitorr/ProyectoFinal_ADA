package com.example.JPA.MySQL.services

import com.example.JPA.MySQL.data.Pelicula
import com.example.JPA.MySQL.data.User
import com.example.JPA.MySQL.repository.PeliculaRepository
import com.example.JPA.MySQL.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService  {
    @Autowired
    private val userRepository: UserRepository ?= null

    @Autowired
    private val peliculaRepository:PeliculaRepository ?= null

    /**
     * añade un usuario
     * @param nombreUser nombre del nuevo usuario
     */
    fun addNewUser(
            nombreUser: String?
    ): String {
        val n = User()
        n.nombreUser = nombreUser
        userRepository!!.save(n)
        return "Saved"
    }


    /**
     * @return obtiene todos los usuarios
     */

    fun getAllUsers(): Iterable<User?> {
        return userRepository!!.findAll()
    }

    /**
     * @param nombreUser nombre del usuario
     * @return obtiene los usuarios con ese nombre
     */
    fun getUsersByName(nombreUser: String?): Iterable<User?> {
        return if (nombreUser.isNullOrEmpty()) {
            userRepository!!.findAll()
        } else {
            userRepository!!.findUserByNombreUser(nombreUser)
        }
    }


    /**
     * @param idUser id del usuario
     * @return devuelve el usuario por id
     */
    fun getUsersById(idUser: Int?): User {
        return if (idUser == null) {
            User()
        } else {
            userRepository!!.findUserByIdUser(idUser)
        }
    }

    /**
     * @param nombreUser nombre usuario
     * @return deuvelve un mensaje de si el usuario se ha borrado
     */
    fun deleteUserByNombreUser(nombreUser: String?):String{
        if(nombreUser.isNullOrEmpty()){
            return "No se encontró el usuario $nombreUser"
        }else{
            var usuario = getUsersByName(nombreUser).first()
            userRepository!!.delete(usuario!!)
            return "Usuario borrado $nombreUser"
        }
    }


    /**
     * @param nombreUser nombre antiguo del usuario que quiero modificar
     * @param nombreNuevo nombre nuevo del usuario
     * @return mensaje de usuario modificado o no se encontró el usuario
     */
    fun updateUserByNombreUser(nombreUser: String?,nombreNuevo:String?):String{
        if(nombreUser.isNullOrEmpty()){
            return "No se encontró el usuario $nombreUser"
        }else{
            var usuario = getUsersByName(nombreUser).first()
            usuario?.nombreUser = nombreNuevo
            userRepository!!.save(usuario!!)
            return "Usuario modificado $nombreUser por $nombreNuevo"
        }
    }


    /**
     * @param nombreUser nombre del usuario
     * @return obtiene las peliculas del usuario
     */
    fun getFilmsByUser(nombreUser: String): Iterable<Pelicula?> {
        if(nombreUser.isEmpty()){
            return peliculaRepository!!.findAll()
        }else{
            var usuario = userRepository!!.findUserByNombreUser(nombreUser).first()
            return peliculaRepository!!.findPeliculaByUsuario(usuario!!)
        }
    }
}