package net.tcgdex.sdk.models.subs

/**
 * Card variants
 */
data class CardVariants(

	/**
	 * basic variant no special effects
	 */
	val normal: Boolean?,

	/**
	 * the card have some shine behind colored content
	 */
	val reverse: Boolean?,

	/**
	 * the card picture have some shine to it
	 */
	val holo: Boolean?,

	/**
	 * the card contains a First Edition Stamp (only Base serie)
	 */
	val firstEdition: Boolean?,

	/**
	 * the card has a wPromo stamp on it
	 */
	val wPromo: Boolean?
)
