package com.tulio.model.entity

/**
 * Entidade do animal.
 * @param id Identificador do animal.
 * @param name Nome do animal.
 * @param type Tipo do animal.
 */
@Entity(name = "tas_ani_animal")
class Animal (
    @Column(name = "ani_id")
    val id: Long? = null,

    @Column(name = "ani_name")
    val name: String,

    @Column(name = "ani_type")
    @Enumerated(EnumType.String)
    val type: Animal.Type,
) {

    /**
     * Enum para identificação do tipo do animal.
     */
    enum class Type {
        TESTE1,
        TESTE2,
        TESTE3
    }
}