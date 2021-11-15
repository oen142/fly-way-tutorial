package com.example.flyway.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @RequestMapping(value = ["/"])
    fun index(): String {
        return "Hello Flyway"
    }
}