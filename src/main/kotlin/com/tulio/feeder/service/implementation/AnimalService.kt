package com.tulio.feeder.service.implementation

import com.tulio.feeder.exception.AlreadyExistsException
import com.tulio.feeder.exception.NotFoundException
import com.tulio.feeder.mapper.IAnimalMapper
import com.tulio.feeder.model.entity.Animal
import com.tulio.feeder.model.form.AnimalForm
import com.tulio.feeder.repository.IAnimalRepository
import com.tulio.feeder.service.IAnimalService
import org.springframework.stereotype.Service

@Service
class AnimalService(
    private val animalRepository: IAnimalRepository,
    private val foodRepository: IAnimalRepository,
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

        //Todo Encontra no banco das comidas os ids passados como comidas preferenciais
        animalForm.primaryPreference.forEach { food ->
            val optionalFood = foodRepository.findById(food.toLong())
            if(!optionalFood.isPresent) throw NotFoundException(notFoundFoodException + " Id: " + food + ".")
        }

        //Todo Ajustar relacionamento no banco. A comida deve ser cadastrada sem necessidade de estar vinculada à um animal,
        // mas um animal poderá ter uma comida associada.
        // Para isso, será necessária uma tabela que guardará as comidas dos animais, sendo elas preferidas ou proibidas.
        // A tabela terá seu id como chave primária, o id do animal, o id da comida
        // e um identificador (pode ser um enum), se a comida é preferida ou proibida.
        // Para buscar os dados desta tabela, será feito um find com o sql explícito.
        // Esse sql pode também buscar uma função feita em plsql.
        // O importante é que essa query retorne todas as comidas associadas a este animal e liste elas em um DTO.
        // Para listá-las, será necessário o uso de um foreach jogando o resultado da collection dentro do dto.
        // Talvez haja problemas na entidade, mas lembre-se que agora essa tabela, por ser uma nova tabela de relacionamento,
        // deve ter sua própria entidade. Isto provavelmente poderá solucionar os problemas atuais de banco.
        val animal = animalMapper.toAnimal(animalForm)
        animalRepository.save(animal)

        return println("Cadastrei")
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