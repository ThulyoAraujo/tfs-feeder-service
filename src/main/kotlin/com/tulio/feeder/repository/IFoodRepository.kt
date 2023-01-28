package com.tulio.feeder.repository

import com.tulio.feeder.model.entity.Food
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IFoodRepository : CrudRepository<Food, Long>