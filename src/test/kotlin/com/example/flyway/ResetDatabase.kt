package com.example.flyway

import org.flywaydb.core.Flyway
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class ResetDatabase {
    @Autowired
    private lateinit var flyway: Flyway

    @BeforeEach
    fun setUp() {
        flyway.clean()
        flyway.migrate()
    }
}