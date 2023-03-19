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
     */
    //Todo Ajustar retorno Any
    //Todo Try catch poderia evitar do código salvar entidades se o código der erro
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
     * @param id Identificador único do animal.
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

    /**
     * Deleta os registros de um animal do banco.
     * @param id Identificador único do animal.
     * @return
     */
    @DeleteMapping("/{id}")
    fun deleteAnimal(
        @PathVariable("id") id: Long
    ): Any {
        return animalService.deleteAnimal(id)
    }
}