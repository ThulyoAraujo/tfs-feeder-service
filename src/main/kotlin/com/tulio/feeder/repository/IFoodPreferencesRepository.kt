package com.tulio.feeder.repository

import com.tulio.feeder.model.entity.FoodPreferences
import org.springframework.data.repository.CrudRepository

interface IFoodPreferencesRepository : CrudRepository<FoodPreferences, Long>