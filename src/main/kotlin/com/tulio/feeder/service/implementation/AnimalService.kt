package com.tulio.feeder.service.implementation

import com.tulio.feeder.mapper.IAnimalMapper
import com.tulio.feeder.model.form.AnimalForm
import com.tulio.feeder.repository.IAnimalRepository
import com.tulio.feeder.service.IAnimalService
import org.springframework.stereotype.Service

@Service
class AnimalService(
    private val animalRepository: IAnimalRepository,
    private val animalMapper: IAnimalMapper
): IAnimalService {

    override fun helloWorld(): String {
        return "Hello World by Service!"
    }

    override fun findAll(): Any {
        return animalRepository.findAll()
    }

    override fun createAnimal(form: AnimalForm): Any {
        val animal = animalMapper.toAnimal(form)
        return animalRepository.save(animal)
    }
}