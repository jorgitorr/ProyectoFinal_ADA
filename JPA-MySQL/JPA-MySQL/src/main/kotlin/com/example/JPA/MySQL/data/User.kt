package com.example.JPA.MySQL.data

import jakarta.persistence.*

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var idUser: Int? = null
    var nombreUser: String? = null
}