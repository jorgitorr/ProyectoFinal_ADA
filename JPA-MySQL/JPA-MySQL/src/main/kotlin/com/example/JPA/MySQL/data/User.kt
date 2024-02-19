package com.example.JPA.MySQL.data

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var idUser: Int? = null
    var nombreUser: String? = null

    @OneToMany(mappedBy = "idLista", fetch = FetchType.LAZY)
    var listas: MutableList<Lista> = mutableListOf()
}