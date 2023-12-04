package com.ifpb.devweb.projetodevweb.controller

import com.ifpb.devweb.projetodevweb.domain.Apostador
import com.ifpb.devweb.projetodevweb.model.dto.CriarApostadorDTO
import com.ifpb.devweb.projetodevweb.model.dto.EditarApostadorDTO
import com.ifpb.devweb.projetodevweb.results.*
import com.ifpb.devweb.projetodevweb.service.ApostadorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/apostador")
class ApostadorController(private val apostadorService: ApostadorService) {
    @PostMapping
    fun criarApostador(@RequestBody body: CriarApostadorDTO): ResponseEntity<*> {
        return with(body) {
            val entity = Apostador(
                    id = UUID.randomUUID(),
                    nome = nome,
                    email = email,
                    dataDeNascimento = dataDeNascimento
            )
            when (apostadorService.criarApostador(entity)) {
                is EmailJaExistenteResult -> ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário com esse email já cadastrado")
                is ApostadorCriadoResult -> ResponseEntity.status(HttpStatus.CREATED).body(entity)
            }
        }
    }

    @GetMapping
    fun listarApostadores(): ResponseEntity<*> {
        return when (val result = apostadorService.listarApostador()) {
            is ListarOkResult -> ResponseEntity.status(HttpStatus.OK).body(result.apostadores)
        }
    }

    @PutMapping("/{id}")
    fun editarApostador(@PathVariable("id") id: UUID, @RequestBody body: EditarApostadorDTO): ResponseEntity<*> {
        return when(apostadorService.editarApostador(body.nome, body.email, id)) {
            is EditarOkResult -> ResponseEntity<Unit>(HttpStatus.OK)
            is ApostadorNaoEncontradoResult -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apostador \"$id\" não encontrado")
        }
    }
}