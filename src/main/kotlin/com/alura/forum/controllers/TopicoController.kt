package com.alura.forum.controllers

import com.alura.forum.dtos.AtualizacaoTopicoForm
import com.alura.forum.dtos.NovoTopicoForm
import com.alura.forum.dtos.TopicoView
import com.alura.forum.services.TopicoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoView> {
        return topicoService.listar();
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return topicoService.buscarPorId(id);
    }

    @PostMapping()
    fun cadastrar(@RequestBody @Valid novoTopicoForm: NovoTopicoForm) {
        topicoService.cadastrar(novoTopicoForm);
    }

    @PutMapping()
    fun atualizar(@RequestBody @Valid atualizacaoTopicoForm: AtualizacaoTopicoForm) {
        topicoService.atualizar(atualizacaoTopicoForm);
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        topicoService.deletar(id);
    }
}