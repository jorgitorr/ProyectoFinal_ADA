package com.example.JPA.MySQL.repository

import com.example.JPA.MySQL.data.User
import org.springframework.data.repository.CrudRepository


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
interface UserRepository : CrudRepository<User?, Int?>{
    fun findByNombreUser(nombreUser: String): List<User?>
}
