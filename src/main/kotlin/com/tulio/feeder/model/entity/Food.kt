package com.tulio.feeder.model.entity

import javax.persistence.*

/**
 * @param id Identificador único da comida.
 * @param name Nome da comida.
 * @param foodType Tipo da comida cadastrada. Enum com tipos vegetal ou animal.
 * @param note Descrição sobre a comida.
 */
@Entity(name = "tfs_foo_food")
class Food(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foo_id")
    var id: Long? = null,

    @Column(name = "foo_name")
    var name: String,

    @Column(name = "foo_food_type")
    @Enumerated(EnumType.STRING)
    var foodType: FoodType? = FoodType.VEGETABLE,

    @Column(name = "foo_note")
    var note: String? = null
)