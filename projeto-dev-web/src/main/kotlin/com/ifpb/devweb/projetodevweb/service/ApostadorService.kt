package com.ifpb.devweb.projetodevweb.service

import com.ifpb.devweb.projetodevweb.domain.Apostador
import com.ifpb.devweb.projetodevweb.results.*
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.mapTo
import org.jdbi.v3.core.kotlin.useHandleUnchecked
import org.jdbi.v3.core.kotlin.withHandleUnchecked
import org.springframework.stereotype.Service

@Service
class ApostadorService(
        private val jdbi: Jdbi,
) {
    fun criarApostador(apostador: Apostador): CriarApostadorResults {
        return jdbi.withHandleUnchecked { handle ->
            apostador.email?.let {
                val exists = handle.createQuery("select exists(select * from apostadores where email = :email)").bind("email", it).mapTo(Int::class.java).first() > 0
                if (exists) {
                    return@withHandleUnchecked EmailJaExistenteResult
                }
            }

            val statement = handle.createUpdate("insert into apostadores(id, nome, email, data_nascimento) values (:id, :nome, :email, :dataDeNascimento)")
            statement.bindBean(apostador)
            statement.execute()
            return@withHandleUnchecked ApostadorCriadoResult
        }
    }

    fun listarApostador(): ListarApostadoresResults {
        return jdbi.withHandleUnchecked { handle ->
            OkResult(
                handle.createQuery("select * from apostadores limit 100").mapTo(Apostador::class.java).list()
            )
        }
    }
}