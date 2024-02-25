package com.example.JPA.MySQL.data

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val idPelicula: Int? = null
    var tituloPelicula: String? = null
    var vista: Int? = 0 //si es 0 es que la pelicula no la ha visto, si es 1 es que si
    var fecha: LocalDateTime?= null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idActor")
    var protagonista: Actor? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    var usuario: User?=null
}