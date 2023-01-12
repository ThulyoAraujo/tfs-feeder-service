package com.tulio.feeder.service

import com.tulio.feeder.model.form.AnimalForm

/**
 * Interface do cadastro de animais.
 */
interface IAnimalService {

    fun helloWorld(): String

    fun findAll(): Any

    fun createAnimal(form: AnimalForm): Any
}