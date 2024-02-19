package com.example.JPA.MySQL.data

import jakarta.persistence.*

@Entity
@Table(name = "actores")
class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var idActor: Int? = null
    var nombreActor: String? = null

    @OneToMany(mappedBy = "protagonista", fetch = FetchType.LAZY)
    var peliculas: MutableList<Pelicula>? = null
}