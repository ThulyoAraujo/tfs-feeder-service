package com.tulio.feeder.controller

import com.tulio.feeder.service.IMainService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Controlador principal da aplicação
 * com os cálculos da alocação dos animais.
 */
@RestController
@RequestMapping("/api")
class MainController(
    private val mainService: IMainService
) {

    /* TODO Adicionar endpoint que consiga, a partir dos ids ou nomes dos animais, escolher a melhor configuração
        de alimentação e quantidade de ambientes para os animais, priorizando a menor utilização de ambiente
        e impedindo de animais serem incomodados pela comida dos outros
    */
    @GetMapping
    fun relocatesAnimals(@RequestParam animalsIds: List<Long>): Any {
        return mainService.realocatesAnimals(animalsIds)
    }
}