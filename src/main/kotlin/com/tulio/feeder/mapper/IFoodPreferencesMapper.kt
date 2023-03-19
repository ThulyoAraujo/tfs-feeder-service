package com.tulio.feeder.mapper

import com.tulio.feeder.model.dto.FoodPreferencesDTO
import com.tulio.feeder.model.entity.FoodPreferences
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper
interface IFoodPreferencesMapper {
    @Mappings(
        Mapping(target = "id", ignore = true),
        Mapping(target = "animalId", ignore = true)
    )
    fun toFoodPreferencesDTO(foodPreferences: MutableList<FoodPreferences>): MutableList<FoodPreferencesDTO>

}