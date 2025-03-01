package com.alura.forum.services

import com.alura.forum.models.Curso
import com.alura.forum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(private val cursoRepository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return cursoRepository.getReferenceById(id)
    }
}
