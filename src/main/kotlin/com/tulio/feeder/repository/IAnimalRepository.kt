package com.tulio.feeder.repository

import com.tulio.feeder.model.entity.Animal
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface IAnimalRepository : CrudRepository<Animal, Long> {
    /* Encontra todos os animais pelo nome ignorando maiúsculas e minúsculas. */
    fun findByNameIgnoreCase(name: String) : Optional<Animal>
}