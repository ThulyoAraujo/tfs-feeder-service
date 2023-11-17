package com.tulio.feeder.service.implementation

import com.tulio.feeder.exception.AlreadyExistsException
import com.tulio.feeder.exception.NotFoundException
import com.tulio.feeder.mapper.IAnimalMapper
import com.tulio.feeder.mapper.IFoodPreferencesMapper
import com.tulio.feeder.model.dto.AnimalDTO
import com.tulio.feeder.model.dto.IAnimalDTO
import com.tulio.feeder.model.entity.Animal
import com.tulio.feeder.model.entity.FoodPreferences
import com.tulio.feeder.model.entity.PreferenceLevel
import com.tulio.feeder.model.form.AnimalForm
import com.tulio.feeder.repository.IAnimalRepository
import com.tulio.feeder.repository.IFoodPreferencesRepository
import com.tulio.feeder.repository.IFoodRepository
import com.tulio.feeder.service.IAnimalService
import org.springframework.stereotype.Service
import org.springframework.transaction.UnexpectedRollbackException
import javax.transaction.Transactional

@Service
class AnimalService(
    private val animalRepository: IAnimalRepository,
    private val foodRepository: IFoodRepository,
    private val foodPreferencesRepository: IFoodPreferencesRepository,
    private val animalMapper: IAnimalMapper,
    private val foodPreferencesMapper: IFoodPreferencesMapper,
    private val notFoundAnimalException: String = "Nada encontrado em nosso banco de dados.",
    private val notFoundFoodException: String = "Comida não encontrada em nosso banco de dados.",
    private val alreadyExistsException: String = "Este animal já existe em nosso banco de dados.",
    private val dataPersistException: String = "Erro ao persistir os dados no banco de dados. "

) : IAnimalService {

    override fun findAll(): List<IAnimalDTO> {
        try {
            val animalDTO = IAnimalDTO::class.java
            return animalRepository.findAllBy(animalDTO)
        } catch (e: Exception){
            throw Exception(notFoundAnimalException)
        }
    }

    @Transactional
    override fun createAnimal(animalForm: AnimalForm): AnimalDTO {
        //Verifica se já não existe esse animal no banco.
        val optionalAnimal = animalRepository.findByNameIgnoreCase(animalForm.name)
        if (optionalAnimal.isPresent) throw AlreadyExistsException(alreadyExistsException)

        val animal = animalMapper.toAnimal(animalForm)

        try {
            //Salva o animal
            val animalSaved = animalRepository.save(animal)

            //Salva as preferências de comidas
            val listOffoodPreferencesSaved = mutableListOf<FoodPreferences>()
            animalForm.primaryPreference?.forEach { primary ->
                val optionalFood = foodRepository.findById(primary)
                if (optionalFood.isEmpty) throw NotFoundException("$notFoundFoodException Id: ${primary}.")
                val foodPreferences = FoodPreferences(null, animalSaved, optionalFood.get(), PreferenceLevel.PRIMARY)
                val primaryFoodPreferencesSaved = foodPreferencesRepository.save(foodPreferences)
                listOffoodPreferencesSaved.add(primaryFoodPreferencesSaved)
            }
            animalForm.secondaryPreference?.forEach { secondary ->
                val optionalFood = foodRepository.findById(secondary)
                if (optionalFood.isEmpty) throw NotFoundException("$notFoundFoodException Id: ${secondary}.")
                val foodPreferences = FoodPreferences(null, animalSaved, optionalFood.get(), PreferenceLevel.SECONDARY)
                val secondaryFoodPreferencesSaved = foodPreferencesRepository.save(foodPreferences)
                listOffoodPreferencesSaved.add(secondaryFoodPreferencesSaved)
            }
            animalForm.prohibited?.forEach { prohibited ->
                val optionalFood = foodRepository.findById(prohibited)
                if (optionalFood.isEmpty) throw NotFoundException("$notFoundFoodException Id: ${prohibited}.")
                val foodPreferences = FoodPreferences(null, animalSaved, optionalFood.get(), PreferenceLevel.PROHIBITED)
                val prohibitedFoodPreferencesSaved = foodPreferencesRepository.save(foodPreferences)
                listOffoodPreferencesSaved.add(prohibitedFoodPreferencesSaved)
            }

            val animalDTO = animalMapper.toAnimalDTO(animalSaved)
            animalDTO.foodPreferences = foodPreferencesMapper.toFoodPreferencesDTO(listOffoodPreferencesSaved)

            return animalDTO
        } catch (e: Exception) {
            throw UnexpectedRollbackException(dataPersistException + e.message)
        }
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