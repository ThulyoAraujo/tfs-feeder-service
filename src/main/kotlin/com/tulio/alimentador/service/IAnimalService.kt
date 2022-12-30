package com.tulio.alimentador.service

import org.springframework.stereotype.Service

/**
 * Interface para CRUD de animais.
 */
@Service
interface IAnimalService {

    /**
     * Procura um animal pelo id.
     */
    fun findAnimalById(identifier: Long): String
}