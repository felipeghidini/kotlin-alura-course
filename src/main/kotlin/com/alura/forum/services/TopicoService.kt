package com.alura.forum.services

import com.alura.forum.dtos.AtualizacaoTopicoForm
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

    fun cadastrar(novoTopicoForm: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(novoTopicoForm);
        topico.id = topicos.size.toLong() + 1;
        topicos = topicos.plus((topico));
        return topicoViewMapper.map(topico);
    }

    fun atualizar(atualizacaoTopicoForm: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == atualizacaoTopicoForm.id;
        }.findFirst().get()
        val topicoAtualizado = Topico(
            id = atualizacaoTopicoForm.id,
            titulo = atualizacaoTopicoForm.titulo,
            mensagem = atualizacaoTopicoForm.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
        topicos = topicos.minus(topico).plus(topicoAtualizado);
        return topicoViewMapper.map(topicoAtualizado);
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        topicos = topicos.minus(topico);
    }
}

