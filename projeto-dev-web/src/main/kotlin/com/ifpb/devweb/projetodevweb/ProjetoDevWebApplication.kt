package com.ifpb.devweb.projetodevweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class ProjetoDevWebApplication

fun main(args: Array<String>) {
    runApplication<ProjetoDevWebApplication>(*args)
}
