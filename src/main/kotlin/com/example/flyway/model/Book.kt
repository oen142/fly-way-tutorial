package com.example.flyway.model

import javax.persistence.*

@Entity
@Table(name = "books")
class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "books_id")
    var id: Long? = 0L,

    @Column
    var name: String,

    @Column
    var author: String
)