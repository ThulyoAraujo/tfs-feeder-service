package com.tulio.feeder.model.dto

import com.tulio.feeder.model.entity.PreferenceLevel

class FoodPreferencesDTO(
    var foodId: Long,
    var preferenceLevel: PreferenceLevel
)