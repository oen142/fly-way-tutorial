package com.example.flyway.configs

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
class FlywayConfig {
    @Value("\${spring.datasource.url}")
    private val URL: String? = null

    @Value("\${spring.datasource.username}")
    private val USERNAME: String? = null

    @Value("\${spring.datasource.password}")
    private val PASSWORD: String? = null

    @Bean
    @Profile("test")
    fun flyway(): Flyway {
        return Flyway
            .configure()
            .dataSource(URL, USERNAME, PASSWORD)
            .load()
    }
}