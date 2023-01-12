package com.tulio.feeder.mapper

import com.tulio.feeder.model.entity.Animal
import com.tulio.feeder.model.form.AnimalForm
import org.mapstruct.Mapper
import org.mapstruct.Mappings

@Mapper
interface IAnimalMapper {
    @Mappings()
    fun toAnimal(form: AnimalForm): Animal
}