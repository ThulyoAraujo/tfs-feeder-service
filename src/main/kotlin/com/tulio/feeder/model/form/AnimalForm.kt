package com.tulio.feeder.model.form

import com.tulio.feeder.model.entity.FoodType
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Formulário que recebe dados de um animal.
 * @param name Nome do animal.
 * @param foodType Tipo da comida do animal. Enum para saber se o animal é carnívoro ou herbívoro.
 * @param primaryPreference Lista de comidas preferidas do animal. Recebemos os ids das comidas previamente cadastradas no banco.
 */
class AnimalForm (

    @field:Size(message = "O nome do animal não deve ter menos de três dígitos.", min = 3)
    @field:NotBlank(message = "O nome do animal deve ser informado.")
    var name: String,

    var foodType: FoodType? = FoodType.VEGETABLE,

    @field:NotNull(message = "Ao menos uma comida preferida do animal deve ser informada.")
    var primaryPreference: List<Int>,
//
//    var secundaryPreference: List<Food>? = null,
//
//    var prohibited: List<Food>? = null
)