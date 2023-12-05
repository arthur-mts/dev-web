package com.ifpb.devweb.projetodevweb.service

import com.ifpb.devweb.projetodevweb.domain.Aposta
import com.ifpb.devweb.projetodevweb.results.*
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.withHandleUnchecked
import org.springframework.stereotype.Service

@Service
class ApostaService(
        private val jdbi: Jdbi,
        private val apostadorService: ApostadorService,
        private val concursoService: ConcursoService,
) {
    fun registrarAposta(aposta: Aposta): ApostarResults {
        if (!apostadorService.apostadorExiste(aposta.idApostador)) {
            return ApostarApostadorNaoEncontradoResult
        }

        val concurso = concursoService.encontrarConcurso(aposta.idConcurso) ?: return ApostarConcursoNaoEncontradoResult

        if (concurso.numeroSorteado != null) {
            return ApostaJaRodouResult
        }

        jdbi.withHandleUnchecked { handle ->
            val statement = handle
                    .createUpdate(
                            """
                            insert into apostas(id, id_apostador, numero_apostado, data_aposta, id_concurso)
                            values (:id, :idApostador, :numeroApostado, :dataAposta, :idConcurso)
                            """.trimIndent()
                    )
            statement.bindBean(aposta)
            statement.execute()
        }
        return ApostaCriadaResult
    }
}