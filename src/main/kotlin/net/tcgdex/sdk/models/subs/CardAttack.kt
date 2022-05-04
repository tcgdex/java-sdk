package net.tcgdex.sdk.models.subs

/**
 * Describes a single attack of a pokemon, for example 'Confuse Ray'
 */
data class CardAttack internal constructor(


	/**
	 * Name of the attack
	 */
	val name: String,

	/**
	 * Cost of the attack in the same order as listed on the card
	 */
	val cost: List<String>? = null,

	/**
	 * Effect/Description of the attack, may be null for attacks without text
	 */
	val effect: String? = null,

	/**
	 * Damage the attack deals. May just be a number like '30', but can also be a multiplier like 'x20'
	 */
	val damage: String? = null
)
