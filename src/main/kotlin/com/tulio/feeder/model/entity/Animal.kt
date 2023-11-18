package com.tulio.feeder.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

/**
 * @param id Identificador único do animal.
 * @param name Nome do animal.
 * @param foodType Tipo de alimentação. Enum de vegariano ou carnívoro.
 * @param foodPreferences Preferências das comidas do animal. Se gosta ou se lhe fazem mal.
 */
@Entity(name = "tfs_ani_animal")
class Animal(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ani_id")
    var id: Long,

    @Column(name = "ani_name")
    var name: String,

    @Column(name = "ani_food_type")
    @Enumerated(EnumType.STRING)
    var foodType: FoodType? = FoodType.VEGETABLE,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "fop_animal_id", referencedColumnName = "ani_id")
    @JsonIgnore //Evita recursão e apenas serializa esta classe Animal
    var foodPreferences: List<FoodPreferences>? = emptyList(),
)