package com.tulio.feeder.service

import com.tulio.feeder.model.entity.Food
import com.tulio.feeder.model.form.FoodForm
import org.springframework.http.ResponseEntity

/**
 * Interface do cadastro de comidas.
 */
interface IFoodService {

    fun createFood(foodForm: FoodForm): Food

    fun findAll(): Any

    fun updateFood(id: Long, foodForm: FoodForm): Food

    fun deleteFood(id: Long): ResponseEntity<String>

}