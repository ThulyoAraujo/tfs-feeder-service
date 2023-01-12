package com.tulio.feeder.controller

import com.tulio.feeder.service.IAnimalService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/animal")
class AnimalController(
    private val animalService: IAnimalService
) {

    /**
     * Teste de conexão com o controlador.
     */
    @GetMapping("/hello-world")
    fun helloWorld(): String {
        return animalService.helloWorld()
    }

    /**
     * Retorna todos so animais.
     */
    @GetMapping
    fun findAll(): Any {
        return animalService.findAll()
    }
}