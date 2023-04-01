package com.tulio.feeder.services

import com.tulio.feeder.model.dto.IAnimalDTO
import com.tulio.feeder.service.implementation.AnimalService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AnimalServiceTest {

    private val animalService = mock(AnimalService::class.java)

    @Test
    fun shouldReturnAListOfAnimals() {
        val iAnimalDTO1 = mock(IAnimalDTO::class.java)
        val iAnimalDTO2 = mock(IAnimalDTO::class.java)

        whenever(animalService.findAll()).thenReturn(listOf(iAnimalDTO1, iAnimalDTO2))

        val result = animalService.findAll()

        //Espera dois itens na lista e na ordem correta
        assertEquals(2, result.size)
        assertEquals(iAnimalDTO1, result[0])
        assertEquals(iAnimalDTO2, result[1])

        // Verifica se o código é chamado ao menos uma vez
        verify(animalService, times(1)).findAll()
    }

}