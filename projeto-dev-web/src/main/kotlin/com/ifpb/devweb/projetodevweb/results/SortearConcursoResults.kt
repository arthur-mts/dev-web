package com.ifpb.devweb.projetodevweb.results

sealed interface SortearConcursoResults : Result

data object ConcursoJaSorteadoResult : SortearConcursoResults
data object ConcursoNaoEncontradoResult : SortearConcursoResults
data class SorteioOkResult(val ganhadores: List<String>, val numeroSorteado: Int) : SortearConcursoResults
//data object EmailJaExistenteResult: CriarApostadorResults
