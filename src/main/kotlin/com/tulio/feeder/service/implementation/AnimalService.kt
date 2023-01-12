package com.tulio.feeder.service.implementation

import com.tulio.feeder.repository.IAnimalRepository
import com.tulio.feeder.service.IAnimalService
import org.springframework.stereotype.Service

@Service
class AnimalService(
    private var animalRepository: IAnimalRepository
): IAnimalService {

    override fun helloWorld(): String {
        return "Hello World by Service!"
    }

    override fun findAll(): Any {
        return animalRepository.findAll()
    }
}