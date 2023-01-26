package com.tulio.feeder.controller

import com.tulio.feeder.model.form.AccommodationForm
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Controlador para CRUD de alojamentos.
 */
@RestController
@RequestMapping("/api/accommodation")
class AccommodationController (
    private val accommodationService: IAccommodationService
) {
    /**
     * Endpoint para persistência de dados de um alojamento.
     * @param accommodationForm Formulário com dados do alojamento.
     * @return Accommodation entidade.
     */
    @PostMapping
    fun createAnimal(
        @RequestBody @Valid accommodationForm: AccommodationForm
    ): Any {
        return accommodationService.createAccommodation(accommodationForm)
    }

    /**
     * Retorna todas os alojamentos.
     * @return Lista com todos os alojamentos.
     */
    @GetMapping
    fun findAllAnimals(): Any {
        return accommodationService.findAll()
    }

    /**
     * Atualiza dados de uma alojamento específico.
     * @param id Identificador único do alojamento.
     * @param accommodationForm Formulário com dados do alojamento.
     * @return Accommodation entidade.
     */
    @PutMapping("/{id}")
    fun updateAnimal(
        @PathVariable("id") id: Long,
        @RequestBody @Valid accommodationForm: AccommodationForm
    ): Any {
        return accommodationService.updateAccommodation(id, accommodationForm)
    }

    /**
     * Deleta os registros de um alojamento do banco.
     * @param id Identificador único do alojamento.
     * @return
     */
    @DeleteMapping("/{id}")
    fun deleteAnimal(
        @PathVariable("id") id: Long
    ): Any {
        return accommodationService.deleteAccommodation(id)
    }
}