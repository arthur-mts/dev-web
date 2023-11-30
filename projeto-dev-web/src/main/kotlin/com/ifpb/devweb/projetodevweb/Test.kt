package com.ifpb.devweb.projetodevweb

import com.ifpb.devweb.projetodevweb.repository.entities.Foo
import jakarta.annotation.PostConstruct
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.mapTo
import org.springframework.stereotype.Component

@Component
class Test(private val jdbi: Jdbi) {

    @PostConstruct
    fun foo() {
        jdbi.useHandle<Exception> {
            val statement = it.createUpdate("insert into foo(name, age) values (:name, :age)")
            statement.bind("name", "foo")
            statement.bind("age", 20)
            statement.execute()

            val select = it.createQuery("select * from foo where id = :id;")
            select.bind("id", 1)
            val result = select.mapTo<Foo>()
            println(result.first())
        }
    }

}