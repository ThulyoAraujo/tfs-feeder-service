package com.tulio.feeder.service

/**
 * Interface do principal do projeto.
 */
interface IMainService {

    fun realocatesAnimals(animalsIds: List<Long>): Any
}