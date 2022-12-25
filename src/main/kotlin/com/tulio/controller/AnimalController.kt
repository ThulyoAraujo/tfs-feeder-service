package com.tulio.controller

import com.tulio.service.IAnimalService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/animal")
class AnimalController(
    private val animalService: IAnimalService
) {

    @PostMapping()
    fun createAnimal() {
        //Todo
    }

    /**
     * Procura um animal pelo nome.
     */
    @GetMapping("/{identifier}")
    fun findAnimal(@PathVariable identifier: Any) {
        return animalService.findAnimal(identifier)
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