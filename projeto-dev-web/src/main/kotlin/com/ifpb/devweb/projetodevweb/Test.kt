package com.ifpb.devweb.projetodevweb

import com.ifpb.devweb.projetodevweb.repository.entities.Foo
import com.ifpb.devweb.projetodevweb.repository.entities.FooRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class Test(private val fooRepository: FooRepository) {

    @PostConstruct
    fun initDatabase() {
        val entity = Foo(10, "FOO", null, null)
        fooRepository.save(entity)
    }
}
