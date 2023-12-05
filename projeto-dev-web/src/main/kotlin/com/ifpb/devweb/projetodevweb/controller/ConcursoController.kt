package com.ifpb.devweb.projetodevweb.controller

import com.ifpb.devweb.projetodevweb.domain.Concurso
import com.ifpb.devweb.projetodevweb.model.dto.CriarConcursoDTO
import com.ifpb.devweb.projetodevweb.results.*
import com.ifpb.devweb.projetodevweb.service.ConcursoService
import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.util.UUID

@RestController
@RequestMapping("/concurso")
class ConcursoController(
        private val concursoService: ConcursoService,
) {
    @PostMapping
    fun criarConcurso(@RequestBody criarConcursoDTO: CriarConcursoDTO): ResponseEntity<*> {
        // TODO: adicionar criador do concurso?
        if (criarConcursoDTO.dataSorteio < LocalDate.now()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data do sorteio inválida")
        }
        return with(criarConcursoDTO) {
            val entity = Concurso(
                    id = UUID.randomUUID(),
                    nome = nome,
                    dataSorteio = dataSorteio,
                    numeroSorteado = null,
            )
            when (concursoService.criarConcurso(entity)) {
                CriarConcursoOkResult -> ResponseEntity.status(HttpStatus.CREATED).body(entity)
            }
        }
    }

    @GetMapping
    fun listarConcursos(): ResponseEntity<*> {
        return when (val result = concursoService.listarConcursos()) {
            is ListarConcursoOkResult -> ResponseEntity.status(HttpStatus.OK).body(result.concursos)
        }
    }

    //TODO: retornar quem ganhou e o numero
    // São numeros de 1-100
    @PatchMapping("/{id}/sortear")
    fun sortearConcurso(@PathVariable("id") id: UUID): ResponseEntity<*> {
        return when (val result = concursoService.sortearConcurso(id)) {
            is ConcursoNaoEncontradoResult -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Concurso não encontrado")
            is SorteioOkResult -> ResponseEntity.status(HttpStatus.OK).body(result)
            is ConcursoJaSorteadoResult -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Concurso já foi sorteado")
        }
    }
}