package com.alura.forum.mapper

import com.alura.forum.dtos.TopicoView
import com.alura.forum.models.Topico
import org.springframework.stereotype.Component


@Component
class TopicoViewMapper: Mapper<Topico, TopicoView> {

    override fun map(t: Topico): TopicoView {
        return TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            status = t.status,
            dataCriacao = t.dataCriacao
        )
    }
}