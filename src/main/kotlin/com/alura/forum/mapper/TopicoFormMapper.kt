package com.alura.forum.mapper

import com.alura.forum.dtos.NovoTopicoForm
import com.alura.forum.models.Topico
import com.alura.forum.services.CursoService
import com.alura.forum.services.UsuarioService
import org.springframework.stereotype.Component


@Component
class TopicoFormMapper(
    private var cursoService: CursoService,
    private var usuarioService: UsuarioService,
): Mapper<NovoTopicoForm, Topico> {

    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }

}
