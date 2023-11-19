package com.tulio.feeder.service.implementation

import com.tulio.feeder.service.IMainService
import org.springframework.stereotype.Service

/**
 * Serviço principal do projeto.
 */
@Service
class MainService() : IMainService {
    override fun realocatesAnimals(animalsIds: List<Long>): Any {
        return "Lista: $animalsIds"
    }
}