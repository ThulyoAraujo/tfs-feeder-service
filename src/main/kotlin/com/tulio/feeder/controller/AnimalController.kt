package com.tulio.feeder.controller

import com.tulio.feeder.model.form.AnimalForm
import com.tulio.feeder.service.IAnimalService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

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

    @PostMapping
    fun createAnimal(
        @RequestBody @Valid form: AnimalForm
    ): Any {
        return animalService.createAnimal(form)
    }

    /**
     * Retorna todos so animais.
     */
    @GetMapping
    fun findAll(): Any {
        return animalService.findAll()
    }
}