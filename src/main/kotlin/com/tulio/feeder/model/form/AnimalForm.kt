package com.tulio.feeder.model.form

import javax.validation.constraints.NotBlank

/**
 * Formulário que recebe dados de um animal.
 * @param name Nome do animal.
 */
class AnimalForm (
    @field:NotBlank(message = "O nome não deve ser nulo, vazio ou branco.")
    var name: String
)