package com.tulio.alimentador.controller

import com.tulio.alimentador.service.IAnimalService
import org.springframework.web.bind.annotation.*

/**
 * Controlador para CRUD de animais.
 */
@RestController
@RequestMapping("/api/animal")
class AnimalController(
    var animalService: IAnimalService
) {

    /**
     * Testa a conexão do controlador.
     */
    @GetMapping
    fun testController(): String {
        return "Controlador de animais."
    }

    @PostMapping()
    fun createAnimal() {
        //Todo
    }

    /**
     * Procura um animal pelo id.
     */
    @GetMapping("/{identifier}")
    fun findAnimalById(@PathVariable identifier: Long): String {
        return animalService.findAnimalById(identifier)
    }

    @PutMapping()
    fun updateAnimal() {
        //Todo
    }

    @DeleteMapping()
    fun deleteAnimal() {
        //Todo
    }
}