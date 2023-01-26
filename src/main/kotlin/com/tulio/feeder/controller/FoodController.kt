package com.tulio.feeder.controller

import com.tulio.feeder.model.form.FoodForm
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Controlador para CRUD de comidas.
 */
@RestController
@RequestMapping("/api/food")
class FoodController (
        private val foodService: IFoodService
    ) {
        /**
         * Endpoint para persistência de dados de uma comida.
         * @param foodForm Formulário com dados da comida.
         * @return Food entidade.
         */
        @PostMapping
        fun createAnimal(
            @RequestBody @Valid foodForm: FoodForm
        ): Any {
            return foodService.createFood(foodForm)
        }

        /**
         * Retorna todas as comidas.
         * @return Lista com todas as comidas.
         */
        @GetMapping
        fun findAllAnimals(): Any {
            return foodService.findAll()
        }

        /**
         * Atualiza dados de uma comida específica.
         * @param id Identificador único da comida.
         * @param foodForm Formulário com dados da comida.
         * @return Food entidade.
         */
        @PutMapping("/{id}")
        fun updateAnimal(
            @PathVariable("id") id: Long,
            @RequestBody @Valid foodForm: FoodForm
        ): Any {
            return foodService.updateFood(id, foodForm)
        }

        /**
         * Deleta os registros de uma comida do banco.
         * @param id Identificador único da comida.
         * @return
         */
        @DeleteMapping("/{id}")
        fun deleteAnimal(
            @PathVariable("id") id: Long
        ): Any {
            return foodService.deleteFood(id)
        }
}