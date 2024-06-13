package com.alura.forum.controllers

import com.alura.forum.models.Topico
import com.alura.forum.services.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping
    fun listar(): List<Topico> {
        return topicoService.listar();
    }
}