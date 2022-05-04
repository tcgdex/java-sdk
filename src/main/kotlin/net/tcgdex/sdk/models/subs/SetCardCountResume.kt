package net.tcgdex.sdk.models.subs

/**
 * Set card count resume
 */
data class SetCardCountResume (

	/**
	 * total of number of cards
	 */
	val total: Int,

	/**
	 * number of cards officialy (on the bottom of each cards)
	 */
	val official: Int
)
