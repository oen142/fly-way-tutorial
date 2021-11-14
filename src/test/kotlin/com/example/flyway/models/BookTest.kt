package com.example.flyway.models

import com.example.flyway.ResetDatabase
import com.example.flyway.daos.BookDao
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookTest : ResetDatabase() {
    @Autowired
    private lateinit var bookDao: BookDao

    @Test
    fun createSuccess() {

        val book = Book(1L, "Flyway 정복하기", "김저자")

        bookDao.save(book)

    }
}