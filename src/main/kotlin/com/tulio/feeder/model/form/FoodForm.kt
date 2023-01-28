package com.tulio.feeder.model.form

import com.tulio.feeder.model.entity.FoodType
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

/**
 * Formulário que recebe dados de uma comida.
 * @param name Nome da comida.
 */
class FoodForm (

    @field:Size(message = "O nome da comida não deve ter menos de três dígitos.", min = 3)
    @field:NotBlank(message = "O nome da comida deve ser informado.")
    var name: String? = null,

    var foodType: FoodType? = FoodType.VEGETABLE,

    var note: String? = null
)