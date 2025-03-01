package com.alura.forum.services

import com.alura.forum.models.Usuario
import com.alura.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val usuarioRepository: UsuarioRepository) {


    fun buscarPorId(id: Long): Usuario {
        return usuarioRepository.getReferenceById(id)
        }

}
