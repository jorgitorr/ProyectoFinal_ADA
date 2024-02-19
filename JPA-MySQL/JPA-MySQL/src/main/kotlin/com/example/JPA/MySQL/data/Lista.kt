package com.example.JPA.MySQL.data

import jakarta.persistence.*

@Entity
@Table(name = "listas")
class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var idLista: Int? = null
    var nombre:String?=null
    @OneToMany(mappedBy = "idPelicula", fetch = FetchType.LAZY)
    var peliculas: MutableList<Pelicula> = mutableListOf()

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    var user: User? = null
}