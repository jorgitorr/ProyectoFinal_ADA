package com.example.JPA.MySQL.data

import jakarta.persistence.*

@Entity
@Table(name = "peliculas")
class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val idPelicula: Int? = null
    var tituloPelicula: String? = null
    var vista: Boolean? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idActor")
    val protagonista: Actor? = null
}