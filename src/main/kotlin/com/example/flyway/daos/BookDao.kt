package com.example.flyway.daos

import com.example.flyway.models.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookDao : CrudRepository<Book, Long>