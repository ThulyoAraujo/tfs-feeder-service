package com.tulio.feeder.repository

import com.tulio.feeder.model.entity.Animal
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IAnimalRepository : CrudRepository<Animal, Long>