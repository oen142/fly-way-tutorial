package com.example.flyway.models

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "books")
class Book(

    @Id
    @Column
    var id: Long,

    @Column
    var name: String,

    @Column
    var author: String
)