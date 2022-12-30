package com.tulio.alimentador.service.implementation

import com.tulio.alimentador.repository.AnimalRepository
import com.tulio.alimentador.service.IAnimalService
import org.springframework.stereotype.Service

/**
 * Serviço para CRUD de animais.
 */
@Service
class AnimalServiceImpl(
    val animalRepository: AnimalRepository
): IAnimalService {

    /**
     * Procura um animal pelo id.
     */
    override fun findAnimalById(identifier: Long): String {
        val optional = this.animalRepository.existsById(identifier)
        if (!optional) {
            return "Não achei um animal"
        }

        return "Achei um animal"
    }
}