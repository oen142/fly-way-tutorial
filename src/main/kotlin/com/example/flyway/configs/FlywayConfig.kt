package com.example.flyway.configs

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
class FlywayConfig(

    @Value("\${spring.datasource.url}")
    private val url: String,

    @Value("\${spring.datasource.username}")
    private val username: String,

    @Value("\${spring.datasource.password}")
    private val password: String
) {

    @Bean
    @Profile(value = ["test"])
    fun flyway(): Flyway {

        return Flyway.configure()
            .dataSource(url, username, password)
            .load()

    }

}