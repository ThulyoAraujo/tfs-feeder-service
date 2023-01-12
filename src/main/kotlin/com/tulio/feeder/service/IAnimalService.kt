package com.tulio.feeder.service

import com.tulio.feeder.model.entity.Animal
import com.tulio.feeder.model.form.AnimalForm

/**
 * Interface do cadastro de animais.
 */
interface IAnimalService {

    fun createAnimal(animalForm: AnimalForm): Animal

    fun findAll(): Any

    fun updateAnimal(id: Long, animalForm: AnimalForm): Animal

    fun deleteAnimal(id: Long): Any

}