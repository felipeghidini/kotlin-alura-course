package com.alura.forum.services

import com.alura.forum.dtos.NovoTopicoForm
import com.alura.forum.dtos.TopicoView
import com.alura.forum.mapper.TopicoFormMapper
import com.alura.forum.mapper.TopicoViewMapper
import com.alura.forum.models.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = listOf(),
    private var topicoViewMapper: TopicoViewMapper,
    private var topicoFormMapper: TopicoFormMapper
) {

     fun listar(): List<TopicoView> {
        return topicos.stream().map {
            t -> topicoViewMapper.map(t)
        }.collect(Collectors.toList());
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return topicoViewMapper.map(topico);
    }

    fun cadastrar(novoTopicoForm: NovoTopicoForm) {
        val topico = topicoFormMapper.map(novoTopicoForm);
        topico.id = topicos.size.toLong() + 1;
        topicos = topicos.plus((topico));
    }
}

