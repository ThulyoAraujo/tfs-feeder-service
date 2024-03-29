package com.tulio.feeder.controller

import com.tulio.feeder.model.form.FoodForm
import com.tulio.feeder.service.IFoodService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Controlador para CRUD de comidas.
 */
@RestController
@RequestMapping("/api/food")
class FoodController(
    private val foodService: IFoodService
) {
    /**
     * Endpoint para persistência de dados de uma comida.
     * @param foodForm Formulário com dados da comida.
     * @return Food entidade.
     */
    @PostMapping
    fun createFood(
        @RequestBody @Valid foodForm: FoodForm
    ): Any {
        return foodService.createFood(foodForm)
    }

    /**
     * Retorna todas as comidas.
     * @return Lista com todas as comidas.
     */
    @GetMapping
    fun findAllFoods(): Any {
        return foodService.findAll()
    }

    /**
     * Atualiza dados de uma comida específica.
     * @param id Identificador único da comida.
     * @param foodForm Formulário com dados da comida.
     * @return Food entidade.
     */
    @PutMapping("/{id}")
    fun updateFood(
        @PathVariable("id") id: Long,
        @RequestBody @Valid foodForm: FoodForm
    ): Any {
        return foodService.updateFood(id, foodForm)
    }

    /**
     * Deleta os registros de uma comida do banco.
     * @param id Identificador único da comida.
     * @return Status ok.
     */
    @DeleteMapping("/{id}")
    fun deleteFood(
        @PathVariable("id") id: Long
    ): ResponseEntity<String> {
        return foodService.deleteFood(id)
    }
}