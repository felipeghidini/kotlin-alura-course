package com.alura.forum.services

import com.alura.forum.models.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(
            id = 1,
            nome = "Felipe",
            email = "felipe@mail.com"
        )
        usuarios = listOf(usuario);
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }

}
