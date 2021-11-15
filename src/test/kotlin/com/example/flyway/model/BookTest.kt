package com.example.flyway.model

import com.example.flyway.ResetDatabase
import com.example.flyway.dao.BookDao
import org.assertj.core.api.Assertions
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
        // 1. Test DB를 바라봐야한다.
        // 2. 테스트 수행 할 때마다,  DB가 초기화 되어야 함 (데이터의 상태에 따라 테스트 결과가 달라지는 것을 방지하기 위해)
        // 3. Book 개체가 DB에 생성되는지 테스트.
        val book = Book(
            name = "test name",
            author = "test author"
        )
        bookDao.save(book)


        val findById = bookDao.findById(book.id ?: 1L)

        Assertions.assertThat(findById.isPresent).isTrue


    }
}