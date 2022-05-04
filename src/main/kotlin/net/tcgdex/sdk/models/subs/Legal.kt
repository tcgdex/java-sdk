package net.tcgdex.sdk.models.subs

/**
 * Card Legality
 *
 * _note: cards are always usable in the unlimited tournaments_
 */
data class Legal(

	/**
	 * card is usable in standard tournaments
	 */
	val standard: Boolean,

	/**
	 * card is usable in expanded tournaments
	 */
	val expanded: Boolean
)
