package com.alura.forum.services

import com.alura.forum.models.Curso
import com.alura.forum.models.Topico
import com.alura.forum.models.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
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
        val topico2 = Topico(
            id = 2,
            titulo = "Duvida kotlin 2",
            mensagem = "Variaveis no kotlin 2",
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
        val topico3 = Topico(
            id = 3,
            titulo = "Duvida kotlin 3",
            mensagem = "Variaveis no kotlin 3",
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

        topicos = listOf(topico, topico2, topico3)
    }


    fun listar(): List<Topico> {
        return topicos;
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }
}

