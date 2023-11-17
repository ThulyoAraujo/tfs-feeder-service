package com.tulio.feeder.service.implementation

import com.tulio.feeder.exception.NotFoundException
import com.tulio.feeder.mapper.IFoodMapper
import com.tulio.feeder.model.entity.Food
import com.tulio.feeder.model.form.FoodForm
import com.tulio.feeder.repository.IFoodPreferencesRepository
import com.tulio.feeder.repository.IFoodRepository
import com.tulio.feeder.service.IFoodService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class FoodService(
    private val foodRepository: IFoodRepository,
    private val foodPreferencesRepository: IFoodPreferencesRepository,
    private val foodMapper: IFoodMapper,
    private val notFoundException: String = "Entidade não encontrada.",
    private val unableToDeleteThisEntity: String = "Não foi possível deletar esta entidade.",
    private val entityDeletedSuccessfully: String = "Entidade deletada com sucesso."
): IFoodService {

    override fun findAll(): Any {
        return foodRepository.findAllAndOrderByIdDesc()
    }

    override fun createFood(foodForm: FoodForm): Food {
        val food = foodMapper.toFood(foodForm)
        food.inStock = if (foodForm.inStock != null) foodForm.inStock else true
        return foodRepository.save(food)
    }

    override fun updateFood(id: Long, foodForm: FoodForm): Food {
        val food = foodRepository.findById(id).orElseThrow{NotFoundException(notFoundException)}
        val foodMapped = foodMapper.toFood(foodForm)
        foodMapped.id = id
        foodMapped.inStock = if (foodForm.inStock != null) foodForm.inStock else food.inStock
        return foodRepository.save(foodMapped)
    }

    @Transactional
    override fun deleteFood(id: Long): ResponseEntity<String> {
        val food = foodRepository.findById(id).orElseThrow { NotFoundException(notFoundException) }

        foodPreferencesRepository.deleteAllByFoodId(food)
        try {
            foodRepository.delete(food)
            return ResponseEntity.ok(entityDeletedSuccessfully)
        } catch (e: Exception) {
            throw Exception(unableToDeleteThisEntity)
        }
    }
}