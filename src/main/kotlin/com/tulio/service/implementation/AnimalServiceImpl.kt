package com.tulio.service.implementation

import com.tulio.repository.AnimalRepository
import com.tulio.service.IAnimalService
import org.springframework.stereotype.Service

@Service
class AnimalServiceImpl(
    private val animalRepository: AnimalRepository
): IAnimalService {

    /**
     * Procura um animal pelo nome.
     */
    override fun findAnimal(identifier: Any) {
        return this.animalRepository.findAnimalById(identifier)
    }
}