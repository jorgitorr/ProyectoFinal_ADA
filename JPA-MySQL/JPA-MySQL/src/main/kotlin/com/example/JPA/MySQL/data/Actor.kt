package com.example.JPA.MySQL.data

import jakarta.persistence.*

@Entity
class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var idActor: Int? = null
    var nombreActor: String? = null

    @OneToMany(mappedBy = "idPelicula", fetch = FetchType.LAZY)
    var peliculas: MutableList<Pelicula>? = null
}