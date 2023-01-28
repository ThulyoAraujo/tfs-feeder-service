package com.tulio.feeder.model.entity

import javax.persistence.*

/**
 * @param id Identificador único do animal.
 * @param name Nome do animal.
 */
@Entity(name = "tfs_ani_animal")
class Animal(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ani_id")
    var id: Long? = null,

    @Column(name = "ani_name")
    var name: String,

    @Column(name = "ani_food_type")
    @Enumerated(EnumType.STRING)
    var foodType: FoodType? = FoodType.VEGETABLE,

//    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
//    @JoinColumn(name = "ani_primary_preference", referencedColumnName = "foo_id")
    @Column(name = "ani_primary_preference")
    var primaryPreference: List<Int>? = emptyList(),

//    @ManyToMany
//    @JoinColumn(name = "ani_secundary_preference", referencedColumnName = "foo_id")
//    var secundaryPreference: List<Food>? = null,
//
//    @ManyToMany
//    @JoinColumn(name = "ani_prohibited", referencedColumnName = "foo_id")
//    var prohibited: List<Food>? = null
)