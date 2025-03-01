package com.alura.forum.services

import com.alura.forum.dtos.AtualizacaoTopicoForm
import com.alura.forum.dtos.NovoTopicoForm
import com.alura.forum.dtos.TopicoView
import com.alura.forum.exceptions.NotFoundException
import com.alura.forum.mapper.TopicoFormMapper
import com.alura.forum.mapper.TopicoViewMapper
import com.alura.forum.models.Topico
import com.alura.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private val topicoRepository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado!"
) {

     fun listar(): List<TopicoView> {
        return topicoRepository.findAll().stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicoRepository.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        return topicoViewMapper.map(topico);
    }

    fun cadastrar(novoTopicoForm: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(novoTopicoForm);
        topicoRepository.save(topico)
        return topicoViewMapper.map(topico);
    }

    fun atualizar(atualizacaoTopicoForm: AtualizacaoTopicoForm): TopicoView {
        val topico = topicoRepository.findById(atualizacaoTopicoForm.id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        topico.titulo = atualizacaoTopicoForm.titulo
        topico.mensagem = atualizacaoTopicoForm.mensagem
        return topicoViewMapper.map(topico);
    }

    fun deletar(id: Long) {
        topicoRepository.deleteById(id)
    }
}

