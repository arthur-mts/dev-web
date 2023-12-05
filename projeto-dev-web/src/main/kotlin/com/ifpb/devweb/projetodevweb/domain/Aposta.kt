package com.ifpb.devweb.projetodevweb.domain

import java.time.LocalDate
import java.util.UUID

data class Aposta(
        val id: UUID,
        val idApostador: UUID,
        val idConcurso: UUID,
        val dataAposta: LocalDate,
        val numeroApostado: Int,
)