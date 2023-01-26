package com.tulio.feeder.service.implementation

import com.tulio.feeder.exception.NotFoundException
import com.tulio.feeder.mapper.IAnimalMapper
import com.tulio.feeder.model.entity.Animal
import com.tulio.feeder.model.form.AnimalForm
import com.tulio.feeder.repository.IAnimalRepository
import com.tulio.feeder.service.IAnimalService
import org.springframework.stereotype.Service

@Service
class AnimalService(
    private val animalRepository: IAnimalRepository,
    private val animalMapper: IAnimalMapper,
    private val notFoundException: String = "Animal não encontrado"
): IAnimalService {

    override fun findAll(): Any {
        return animalRepository.findAll()
    }

    override fun createAnimal(animalForm: AnimalForm): Animal {
        val animal = animalMapper.toAnimal(animalForm)
        return animalRepository.save(animal)
    }

    override fun updateAnimal(id: Long, animalForm: AnimalForm): Animal {
        val animal = animalRepository.findById(id).orElseThrow{NotFoundException(notFoundException)}
        animal.name = animalForm.name
        return animalRepository.save(animal)
    }

    override fun deleteAnimal(id: Long): Any {
        val animal = animalRepository.findById(id).orElseThrow{NotFoundException(notFoundException)}
        return animalRepository.delete(animal)
    }
}