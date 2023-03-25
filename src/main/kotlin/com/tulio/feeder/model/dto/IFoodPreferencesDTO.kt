package com.tulio.feeder.model.dto

import com.tulio.feeder.model.entity.PreferenceLevel

/**
 * Interface usada como DTO para retornar dados específicos das preferências dos animais.
 */
interface IFoodPreferencesDTO {
    var foodId: Long?
    var preferenceLevel: PreferenceLevel?
}