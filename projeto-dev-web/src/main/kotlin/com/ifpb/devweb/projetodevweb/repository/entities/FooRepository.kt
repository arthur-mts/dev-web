package com.ifpb.devweb.projetodevweb.repository.entities;

import org.springframework.data.jpa.repository.JpaRepository

interface FooRepository : JpaRepository<Foo, Int> {
}