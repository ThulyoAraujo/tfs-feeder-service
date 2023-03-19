package com.tulio.feeder.model.form

import com.tulio.feeder.model.entity.FoodType
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

/**
 * Formulário que recebe dados de um animal.
 * @param name Nome do animal.
 * @param foodType Tipo da comida do animal. Enum para saber se o animal é carnívoro ou herbívoro.
 * @param primaryPreference Lista de comidas preferidas do animal. Recebemos os ids das comidas previamente cadastradas no banco.
 * @param secondaryPreference Lista de comidas aceitas normalmente pelo animal. Recebemos os ids das comidas previamente cadastradas no banco.
 * @param prohibited Lista de comidas odiadas ou tóxicas ao animal. Recebemos os ids das comidas previamente cadastradas no banco.
 */
class AnimalForm (

    @field:Size(message = "O nome do animal não deve ter menos de três dígitos.", min = 3)
    @field:NotBlank(message = "O nome do animal deve ser informado.")
    var name: String,

    var foodType: FoodType? = FoodType.VEGETABLE,

    var primaryPreference: List<Long>? = emptyList(),

    var secondaryPreference: List<Long>? = emptyList(),

    var prohibited: List<Long>? = emptyList(),
)