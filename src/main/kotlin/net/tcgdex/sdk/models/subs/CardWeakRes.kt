package net.tcgdex.sdk.models.subs


/**
 * Describes the weakness/resistance of a single pokemon, for example: 2x to Fire
 *
 * @property type the affecting type
 * @property value the multiplier mostly `x2` but can also be `-30`, `+30` depending on the card
 */
data class CardWeakRes internal constructor(
    val type: String,
    val value: String? = null
)
