package com.tulio.feeder.mapper

import com.tulio.feeder.model.dto.AnimalDTO
import com.tulio.feeder.model.entity.Animal
import com.tulio.feeder.model.form.AnimalForm
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper
interface IAnimalMapper {
    @Mappings()
    fun toAnimal(form: AnimalForm): Animal

    @Mappings(
        Mapping(target = "foodPreferences", ignore = true)
    )
    fun toAnimalDTO(animal: Animal): AnimalDTO
}