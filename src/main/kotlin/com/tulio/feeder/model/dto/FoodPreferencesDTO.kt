package com.tulio.feeder.model.dto

import com.tulio.feeder.model.entity.Food
import com.tulio.feeder.model.entity.PreferenceLevel

class FoodPreferencesDTO(
    var foodId: Food,
    var preferenceLevel: PreferenceLevel
)