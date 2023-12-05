package com.ifpb.devweb.projetodevweb.service

import com.ifpb.devweb.projetodevweb.domain.Concurso
import com.ifpb.devweb.projetodevweb.results.*
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.mapTo
import org.jdbi.v3.core.kotlin.withHandleUnchecked
import org.springframework.stereotype.Service
import java.security.SecureRandom
import java.util.UUID

@Service
class ConcursoService(private val jdbi: Jdbi) {
    fun encontrarConcurso(id: UUID): Concurso? {
        return jdbi.withHandleUnchecked { handle ->
            handle.createQuery("select * from concurso where id = :id").bind("id", id).mapTo<Concurso>().firstOrNull()
        }
    }

    fun criarConcurso(concurso: Concurso): CriarConcursoResults {
        return jdbi.withHandleUnchecked { handle ->
            val statement = handle.createUpdate("insert into concurso(id, nome, data_sorteio) values (:id, :nome, :dataSorteio)")
            statement.bindBean(concurso)
            statement.execute()
            CriarConcursoOkResult
        }
    }

    fun listarConcursos(): ListarConcursoResults {
        return jdbi.withHandleUnchecked { handle ->
            ListarConcursoOkResult(
                    concursos = handle.createQuery("select * from concurso").mapTo<Concurso>().list()
            )
        }
    }

    fun sortearConcurso(id: UUID): SortearConcursoResults {

        val numeroSorteadoDB = jdbi.withHandleUnchecked { handle ->
            handle.createQuery("select numero_sorteado from concurso where id = :id").bind("id", id).mapTo(Int::class.java).toList()
        }

        if (numeroSorteadoDB.isEmpty()) {
            return ConcursoNaoEncontradoResult
        }
        if (numeroSorteadoDB.first() > 0) {
            return ConcursoJaSorteadoResult
        }

        val numeroSorteado = SecureRandom().nextInt(1, 100)
        val updatedRows = jdbi.withHandleUnchecked { handle ->
            handle.createUpdate("update concurso set numero_sorteado = :numeroSorteado where id = :id")
                    .bind("id", id)
                    .bind("numeroSorteado", numeroSorteado)
                    .execute()
        }

        if (updatedRows == 0) {
            return ConcursoNaoEncontradoResult
        }
        //TODO: pegar apostas feitas nesse concurso e retornar ganhadores
        return SorteioOkResult(
                ganhadores = listOf(),
                numeroSorteado = numeroSorteado
        )
    }
}