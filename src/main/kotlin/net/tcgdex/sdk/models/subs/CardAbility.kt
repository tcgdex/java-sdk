package net.tcgdex.sdk.models.subs

/**
 * Describes a single ability of a pokemon
 *
 */
data class CardAbility internal constructor(
    /**
     * @return Type of the ability, for example 'Poke-POWER'
     */
    val type: String,
    /**
     * @return Name of the ability
     */
    val name: String,
    /**
     *
     * @return Description/Effect of the ability
     */
    val effect: String
)