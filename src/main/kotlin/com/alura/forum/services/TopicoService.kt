package com.alura.forum.services

import com.alura.forum.dtos.TopicoForm
import com.alura.forum.dtos.TopicoView
import com.alura.forum.models.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = listOf(),
    private var cursoService: CursoService,
    private var usuarioService: UsuarioService,
) {

     fun listar(): List<TopicoView> {
        return topicos.stream().map { t -> TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            status = t.status,
            dataCriacao = t.dataCriacao
        ) }.collect(Collectors.toList());
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return TopicoView(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
    }

    fun cadastrar(topicoForm: TopicoForm) {
        topicos = topicos.plus(Topico(
            id = topicos.size.toLong() + 1,
            titulo = topicoForm.titulo,
            mensagem = topicoForm.mensagem,
            curso = cursoService.buscarPorId(topicoForm.idCurso),
            autor = usuarioService.buscarPorId(topicoForm.idAutor)
        ))
    }
}

