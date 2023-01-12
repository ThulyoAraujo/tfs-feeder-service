package com.tulio.feeder.controller

import com.tulio.feeder.model.form.AnimalForm
import com.tulio.feeder.service.IAnimalService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Controlador para CRUD de animais.
 */
@RestController
@RequestMapping("/api/animal")
class AnimalController(
    private val animalService: IAnimalService
) {
    /**
     * Endpoint para persistência de dados de um animal.
     * @param animalForm Formulário com dados do animal.
     * @return Animal entidade.
     */
    @PostMapping
    fun createAnimal(
        @RequestBody @Valid animalForm: AnimalForm
    ): Any {
        return animalService.createAnimal(animalForm)
    }

    /**
     * Retorna todos os animais.
     * @return Lista com todos os animais.
     */
    @GetMapping
    fun findAllAnimals(): Any {
        return animalService.findAll()
    }

    /**
     * Atualiza dados de um animal específico.
     * @param animalForm Formulário com dados do animal.
     * @return Animal entidade.
     */
    @PutMapping("/{id}")
    fun updateAnimal(
        @PathVariable("id") id: Long,
        @RequestBody @Valid animalForm: AnimalForm
    ): Any {
        return animalService.updateAnimal(id, animalForm)
    }
}