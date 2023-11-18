package com.tulio.feeder.repository

import com.tulio.feeder.model.entity.Food
import com.tulio.feeder.model.entity.FoodPreferences
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IFoodPreferencesRepository : CrudRepository<FoodPreferences, Long> {

    @Modifying
    @Query(value = "DELETE FROM tfs_fop_food_preferences WHERE fop_food_id = :foodId", nativeQuery = true)
    fun deleteAllByFoodId(foodId: Food)

    @Modifying
    @Query(value = "DELETE FROM tfs_fop_food_preferences WHERE fop_animal_id IS NULL", nativeQuery = true)
    fun deleteAllByAnimalIdIsNull()

}