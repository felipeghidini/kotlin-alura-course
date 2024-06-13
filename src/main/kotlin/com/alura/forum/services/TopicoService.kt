package com.alura.forum.services

import com.alura.forum.models.Curso
import com.alura.forum.models.Topico
import com.alura.forum.models.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService {

    fun listar(): List<Topico> {
        val topico = Topico(
            id = 1,
            titulo = "Duvida kotlin",
            mensagem = "Variaveis no kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Felipe",
                email = "felipe@mail.com"
            )
        )

        return listOf(topico, topico, topico)
    }
}
