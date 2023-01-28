package com.tulio.feeder.service.implementation

import com.tulio.feeder.exception.NotFoundException
import com.tulio.feeder.mapper.IFoodMapper
import com.tulio.feeder.model.entity.Food
import com.tulio.feeder.model.form.FoodForm
import com.tulio.feeder.repository.IFoodRepository
import com.tulio.feeder.service.IFoodService
import org.springframework.stereotype.Service

@Service
class FoodService(
    private val foodRepository: IFoodRepository,
    private val foodMapper: IFoodMapper,
    private val notFoundException: String = "Comida não encontrada"
): IFoodService {

    override fun findAll(): Any {
        return foodRepository.findAll()
    }

    override fun createFood(foodForm: FoodForm): Food {
        val food = foodMapper.toFood(foodForm)
        return foodRepository.save(food)
    }

    override fun updateFood(id: Long, foodForm: FoodForm): Food {
        val food = foodRepository.findById(id).orElseThrow{NotFoundException(notFoundException)}
        food.name = foodForm.name.toString()
        return foodRepository.save(food)
    }

    override fun deleteFood(id: Long): Any {
        val food = foodRepository.findById(id).orElseThrow{NotFoundException(notFoundException)}
        return foodRepository.delete(food)
    }
}