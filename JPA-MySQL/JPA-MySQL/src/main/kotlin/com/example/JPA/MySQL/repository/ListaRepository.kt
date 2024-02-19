package com.example.JPA.MySQL.repository

import com.example.JPA.MySQL.data.Lista
import com.example.JPA.MySQL.data.User
import org.springframework.data.repository.CrudRepository

interface ListaRepository:CrudRepository<Lista?,Int?> {
    fun findByUser(user: User):List<Lista>

}