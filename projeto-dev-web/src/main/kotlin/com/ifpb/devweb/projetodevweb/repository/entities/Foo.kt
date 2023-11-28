package com.ifpb.devweb.projetodevweb.repository.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Foo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(nullable = false)
    val name: String? = null,
    @Column
    val description: String? = null,
    @Column
    val age: Int? = null,
)
