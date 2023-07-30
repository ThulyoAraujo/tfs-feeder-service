package com.tulio.feeder.repository

import com.tulio.feeder.model.entity.Food
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IFoodRepository : CrudRepository<Food, Long> {

    @Query(value = "select food from tfs_foo_food as food order by food.id desc")
    fun findAllAndOrderByIdDesc(): MutableIterable<Food>

}