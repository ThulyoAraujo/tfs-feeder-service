package com.tulio.feeder.repository

import com.tulio.feeder.model.dto.IAnimalDTO
import com.tulio.feeder.model.entity.Animal
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

/**
 * Repositório com dados dos animais.
 */
@Repository
interface IAnimalRepository : CrudRepository<Animal, Long> {
    /* Encontra todos os animais pelo nome ignorando maiúsculas e minúsculas. */
    fun findByNameIgnoreCase(name: String) : Optional<Animal>

    /* Encontra todos os animais do banco e já os retorna como o DTO para o usuário final
     sem necessidade de estanciar o Mapper explícitamente. */
    fun findAllBy(animalDTO: Class<out IAnimalDTO>): List<IAnimalDTO>
}