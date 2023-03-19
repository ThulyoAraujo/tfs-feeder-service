package com.tulio.feeder.model.dto

import com.tulio.feeder.model.entity.FoodType

class AnimalDTO (
    var id: Long,
    var name: String,
    var foodType: FoodType,
    var foodPreferences: MutableList<FoodPreferencesDTO>? = mutableListOf<FoodPreferencesDTO>()
)