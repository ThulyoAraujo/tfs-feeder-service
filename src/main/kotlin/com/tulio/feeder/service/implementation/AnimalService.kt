package com.tulio.feeder.service.implementation

import com.tulio.feeder.exception.AlreadyExistsException
import com.tulio.feeder.exception.NotFoundException
import com.tulio.feeder.mapper.IAnimalMapper
import com.tulio.feeder.model.entity.Animal
import com.tulio.feeder.model.entity.FoodPreferences
import com.tulio.feeder.model.entity.PreferenceLevel
import com.tulio.feeder.model.form.AnimalForm
import com.tulio.feeder.repository.IAnimalRepository
import com.tulio.feeder.repository.IFoodPreferencesRepository
import com.tulio.feeder.service.IAnimalService
import org.springframework.stereotype.Service

@Service
class AnimalService(
    private val animalRepository: IAnimalRepository,
    private val foodRepository: IAnimalRepository,
    private val foodPreferencesRepository: IFoodPreferencesRepository,
    private val animalMapper: IAnimalMapper,
    private val notFoundAnimalException: String = "Animal não encontrado em nosso banco de dados.",
    private val notFoundFoodException: String = "Comida não encontrada em nosso banco de dados.",
    private val alreadyExistsException: String = "Este animal já existe em nosso banco de dados."
) : IAnimalService {

    override fun findAll(): Any {
        return animalRepository.findAll()
    }

    override fun createAnimal(animalForm: AnimalForm): Any? {
        //Verifica se já não existe esse animal no banco.
        val optionalAnimal = animalRepository.findByNameIgnoreCase(animalForm.name)
        if(optionalAnimal.isPresent) throw AlreadyExistsException(alreadyExistsException)

        //Valida se existe no banco as comidas passadas como comidas preferenciais.
        animalForm.primaryPreference?.forEach { food ->
            val optionalFood = foodRepository.findById(food.toLong())
            if(!optionalFood.isPresent) throw NotFoundException("$notFoundFoodException Id: $food.")
        }

        // O importante é que essa query retorne todas as comidas associadas a este animal e liste elas em um DTO.
        // Para listá-las, será necessário o uso de um foreach jogando o resultado da collection dentro do dto.

        val animal = animalMapper.toAnimal(animalForm)
        val animalSaved = animalRepository.save(animal)

        //Salva as preferências de comidas
        animalForm.primaryPreference?.forEach { primary ->
            val foodPreferences = FoodPreferences(null, animalSaved.id, primary, PreferenceLevel.PRIMARY)
            foodPreferencesRepository.save(foodPreferences)
        }
        animalForm.secondaryPreference?.forEach { secondary ->
            val foodPreferences = FoodPreferences(null, animalSaved.id, secondary, PreferenceLevel.SECONDARY)
            foodPreferencesRepository.save(foodPreferences)
        }
        animalForm.prohibited?.forEach { prohibited ->
            val foodPreferences = FoodPreferences(null, animalSaved.id, prohibited, PreferenceLevel.PROHIBITED)
            foodPreferencesRepository.save(foodPreferences)
        }

        return println("Cadastrei")

        //Todo Criar DTO
//        return animalDTO
    }

    override fun updateAnimal(id: Long, animalForm: AnimalForm): Animal {
        val animal = animalRepository.findById(id).orElseThrow { NotFoundException(notFoundAnimalException) }
        animal.name = animalForm.name.toString()
        return animalRepository.save(animal)
    }

    override fun deleteAnimal(id: Long): Any {
        val animal = animalRepository.findById(id).orElseThrow { NotFoundException(notFoundAnimalException) }
        return animalRepository.delete(animal)
    }
}