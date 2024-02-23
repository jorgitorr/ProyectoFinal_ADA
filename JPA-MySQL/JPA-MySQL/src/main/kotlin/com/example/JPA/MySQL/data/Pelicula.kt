package com.example.JPA.MySQL.data

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val idPelicula: Int? = null
    var tituloPelicula: String? = null
    var vista: Boolean? = false
    var fecha: LocalDateTime?= null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idActor")
    var protagonista: Actor? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    var usuario: User?=null
}