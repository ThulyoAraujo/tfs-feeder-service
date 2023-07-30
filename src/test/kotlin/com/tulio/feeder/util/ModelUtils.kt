package com.tulio.feeder.util

import com.tulio.feeder.model.dto.IAnimalDTO
import org.mockito.Mockito.mock

class ModelUtils {

    fun getIAnimalDTO(): IAnimalDTO = mock(IAnimalDTO::class.java)
}