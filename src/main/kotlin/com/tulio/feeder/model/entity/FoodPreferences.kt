package com.tulio.feeder.model.entity

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import javax.persistence.*

/**
 * @param id Identificador único das preferências de comida.
 * @param animalId Id do animal associado à estas preferências.
 * @param foodId Id da comida associada à estas preferências.
 * @param preferenceLevel Nível de preferência. Enum de favorita, normal ou proibida ao animal.
 */
@Entity(name = "tfs_fop_food_preferences")
class FoodPreferences (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fop_id")
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "fop_animal_id")
    var animalId: Animal,

    @ManyToOne
    @JoinColumn(name = "fop_food_id")
    @Cascade(CascadeType.ALL)
    var foodId: Food,

    @Column(name = "fop_preference_level")
    @Enumerated(EnumType.ORDINAL)
    var preferenceLevel: PreferenceLevel
)