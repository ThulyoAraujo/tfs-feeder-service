package com.tulio.alimentador.repository

import com.tulio.alimentador.model.entity.Animal
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Repositório para CRUD de animais.
 */
@Repository
interface AnimalRepository: CrudRepository<Animal, Long>
