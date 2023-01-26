package com.tulio.feeder.model.form

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

/**
 * Formulário que recebe dados de um animal.
 * @param name Nome do animal.
 */
class AnimalForm (

    @field:Min(3, message = "O nome do animal não deve ter menos de três dígitos.")
    @field:NotBlank(message = "O nome do animal deve ser enviado.")
    var name: String
)