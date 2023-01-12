package com.tulio.feeder.model.entity

import javax.persistence.*

/**
 * @param id Identificador único do animal.
 * @param name Nome do animal.
 */
@Entity(name = "tfs_fee_feeder")
class Animal(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fee_id")
    var id: Long? = null,

    @Column(name = "fee_name")
    var name: String
) {
}