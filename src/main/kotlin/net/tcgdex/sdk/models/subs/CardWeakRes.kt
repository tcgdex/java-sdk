package net.tcgdex.sdk.models.subs


/**
 * Describes the weakness/resistance of a single pokemon, for example: 2x to Fire
 */
data class CardWeakRes internal constructor(

	/**
	 * the affecting type
	 */
	val type: String,

	/**
	 * the multiplier mostly `x2` but can also be `-30`, `+30` depending on the card
	 */
	val value: String?
)
