package com.tulio.service

import org.springframework.stereotype.Service

/**
 * Interface para CRUD de animais.
 */
@Service
interface IAnimalService {

    /**
     * Procura um animal pelo nome.
     */
    fun findAnimal(identifier: Any)
}