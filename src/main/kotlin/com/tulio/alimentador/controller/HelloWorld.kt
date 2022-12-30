package com.tulio.alimentador.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello-world")
class HelloWorld {

    /**
     * Teste de conexão.
     */
    @GetMapping
    fun hellorWorld(): String {
        return "Hello world! Teste"
    }

}