package com.tulio.feeder.service.implementation

import com.tulio.feeder.service.IMainService
import org.springframework.stereotype.Service

/**
 * Serviço principal do projeto.
 */
@Service
class MainService() : IMainService {
    override fun realocatesAnimals(): Any {
        return "Teste realocatesAnimals"
    }
}