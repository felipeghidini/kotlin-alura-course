package com.alura.forum.models

import jakarta.persistence.*

@Entity
@Table(name = "curso")
data class Curso(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val categoria: String
)

