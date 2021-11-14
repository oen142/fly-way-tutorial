package com.example.flyway.controller

import com.example.flyway.daos.BookDao
import com.example.flyway.models.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/books"])
class BookController {

    @Autowired
    private lateinit var bookDao: BookDao

    @RequestMapping(value = ["/create"])
    fun create(): Book {
        val book = Book(1L, "Flyway 정복하기", "김저자")

        bookDao.save(book)

        return book

    }

}