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
    var name: String
)