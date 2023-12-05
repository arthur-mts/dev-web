package com.ifpb.devweb.projetodevweb.results

sealed interface ApostarResults : Result
data object ApostarApostadorNaoEncontradoResult : ApostarResults
data object ApostarConcursoNaoEncontradoResult : ApostarResults
data object ApostaJaRodouResult : ApostarResults
data object ApostaCriadaResult: ApostarResults