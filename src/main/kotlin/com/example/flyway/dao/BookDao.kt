package com.example.flyway.dao

import com.example.flyway.model.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookDao : CrudRepository<Book, Long>