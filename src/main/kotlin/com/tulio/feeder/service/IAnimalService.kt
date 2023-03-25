package com.tulio.feeder.service

import com.tulio.feeder.model.dto.AnimalDTO
import com.tulio.feeder.model.dto.IAnimalDTO
import com.tulio.feeder.model.entity.Animal
import com.tulio.feeder.model.form.AnimalForm

/**
 * Interface do cadastro de animais.
 */
interface IAnimalService {

    fun createAnimal(animalForm: AnimalForm): AnimalDTO

    fun findAll(): List<IAnimalDTO>

    fun updateAnimal(id: Long, animalForm: AnimalForm): Animal

    fun deleteAnimal(id: Long): Any

}