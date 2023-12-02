package com.ifpb.devweb.projetodevweb.results

import com.ifpb.devweb.projetodevweb.domain.Apostador

sealed interface ListarApostadoresResults : Result
data class OkResult(val apostadores: List<Apostador>): ListarApostadoresResults