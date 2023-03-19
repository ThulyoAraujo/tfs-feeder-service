package com.tulio.feeder.service.implementation

import com.tulio.feeder.exception.AlreadyExistsException
import com.tulio.feeder.exception.NotFoundException
import com.tulio.feeder.mapper.IAnimalMapper
import com.tulio.feeder.mapper.IFoodPreferencesMapper
import com.tulio.feeder.model.dto.AnimalDTO
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
    private val foodPreferencesMapper: IFoodPreferencesMapper,
    private val notFoundAnimalException: String = "Animal não encontrado em nosso banco de dados.",
    private val notFoundFoodException: String = "Comida não encontrada em nosso banco de dados.",
    private val alreadyExistsException: String = "Este animal já existe em nosso banco de dados."
) : IAnimalService {

    override fun findAll(): Any {
        //Todo Adicionar DTO no retorno
        return animalRepository.findAll()
    }

    override fun createAnimal(animalForm: AnimalForm): AnimalDTO {
        //Verifica se já não existe esse animal no banco.
        val optionalAnimal = animalRepository.findByNameIgnoreCase(animalForm.name)
        if(optionalAnimal.isPresent) throw AlreadyExistsException(alreadyExistsException)

        //Valida se existe no banco as comidas passadas como comidas preferenciais.
        animalForm.primaryPreference?.forEach { food ->
            val optionalFood = foodRepository.findById(food)
            if(!optionalFood.isPresent) throw NotFoundException("$notFoundFoodException Id: $food.")
        }

        val animal = animalMapper.toAnimal(animalForm)
        val animalSaved = animalRepository.save(animal)
        val animalDTO = animalMapper.toAnimalDTO(animalSaved)

        //Salva as preferências de comidas
        val listOffoodPreferencesSaved = mutableListOf<FoodPreferences>()
        animalForm.primaryPreference?.forEach { primary ->
            val foodPreferences = FoodPreferences(null, animalSaved.id, primary, PreferenceLevel.PRIMARY)
            val primaryFoodPreferencesSaved = foodPreferencesRepository.save(foodPreferences)
            listOffoodPreferencesSaved.add(primaryFoodPreferencesSaved)
        }
        animalForm.secondaryPreference?.forEach { secondary ->
            val foodPreferences = FoodPreferences(null, animalSaved.id, secondary, PreferenceLevel.SECONDARY)
            val secondaryFoodPreferencesSaved = foodPreferencesRepository.save(foodPreferences)
            listOffoodPreferencesSaved.add(secondaryFoodPreferencesSaved)
        }
        animalForm.prohibited?.forEach { prohibited ->
            val foodPreferences = FoodPreferences(null, animalSaved.id, prohibited, PreferenceLevel.PROHIBITED)
            val prohibitedFoodPreferencesSaved = foodPreferencesRepository.save(foodPreferences)
            listOffoodPreferencesSaved.add(prohibitedFoodPreferencesSaved)
        }
        animalDTO.foodPreferences = foodPreferencesMapper.toFoodPreferencesDTO(listOffoodPreferencesSaved)

        return animalDTO
    }

    override fun updateAnimal(id: Long, animalForm: AnimalForm): Animal {
        val animal = animalRepository.findById(id).orElseThrow { NotFoundException(notFoundAnimalException) }
        animal.name = animalForm.name
        return animalRepository.save(animal)
    }

    override fun deleteAnimal(id: Long): Any {
        val animal = animalRepository.findById(id).orElseThrow { NotFoundException(notFoundAnimalException) }
        return animalRepository.delete(animal)
    }
}