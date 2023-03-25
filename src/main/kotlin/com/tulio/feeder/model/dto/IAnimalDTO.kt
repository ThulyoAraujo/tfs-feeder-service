package com.tulio.feeder.model.dto

import com.tulio.feeder.model.entity.FoodType

/**
 * Interface usada como DTO para retornar dados específicos dos animais.
 */
interface IAnimalDTO {
    var id: Long?
    var name: String?
    var foodType: FoodType?
    var foodPreferences: List<IFoodPreferencesDTO>?
}