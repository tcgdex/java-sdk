package net.tcgdex.sdk.models.subs

/**
 * Describes a single ability of a pokemon
 */
data class CardAbility internal constructor(

    /**
     * The Ability type (language dependant)
     */
    val type: String,

    /**
     * Name of the ability
     */
    val name: String,

    /**
     *
     * Description/Effect of the ability
     */
    val effect: String
)
