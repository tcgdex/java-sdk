package net.tcgdex.sdk.models.subs

/**
 * Describes a single attack of a pokemon, for example 'Confuse Ray'
 *
 * @property name Name of the attack
 * @property cost Cost of the attack in the same order as listed on the card
 * @property effect Effect/Description of the attack, may be null for attacks without text
 * @property damage Damage the attack deals. May just be a number like '30', but can also be a multiplier like 'x20'
 */
data class CardAttack internal constructor(

    val name: String,
    val cost: List<String>? = null,
    val effect: String? = null,
    val damage: String? = null
)
