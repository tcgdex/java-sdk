package net.tcgdex.sdk.models.subs

/**
 * Set card count
 */
data class SetCardCount (

	/**
	 * total of number of cards
	 */
	val total: Int,

	/**
	 * number of cards officialy (on the bottom of each cards)
	 */
	val official: Int,

	/**
	 * number of cards having a normal version
	 */
	val normal: Int,

	/**
	 * number of cards having an reverse version
	 */
	val reverse: Int,

	/**
	 * number of cards having an holo version
	 */
	val holo: Int,

	/**
	 * Number of possible cards
	 */
	val firstEd: Int?
)
