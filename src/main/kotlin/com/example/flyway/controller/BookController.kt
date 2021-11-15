package com.example.flyway.controller

import com.example.flyway.dao.BookDao
import com.example.flyway.model.Book
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(
    private val bookDao: BookDao
) {
    @RequestMapping(value = ["/create"])
    fun create(): Book {
        val book = Book(
            name = "flyway",
            author = "author"
        )
        bookDao.save(book)

        return book
    }

}