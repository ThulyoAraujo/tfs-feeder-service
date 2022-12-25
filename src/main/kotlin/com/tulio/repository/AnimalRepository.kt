package com.tulio.repository

import com.tulio.model.entity.Animal
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Repositório de animais.
 */
@Repository
interface AnimalRepository : CrudRepository<Animal, Long> {
    /**
     * Procura o animal pelo id.
     */
    fun findAnimalById(identifier: Any)
}