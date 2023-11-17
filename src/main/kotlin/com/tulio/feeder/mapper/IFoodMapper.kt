package com.tulio.feeder.mapper

import com.tulio.feeder.model.entity.Food
import com.tulio.feeder.model.form.FoodForm
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper
interface IFoodMapper {
    @Mappings(
        Mapping(target = "id", ignore = true)
    )
    fun toFood(form: FoodForm): Food
}