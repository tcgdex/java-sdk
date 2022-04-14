package net.tcgdex.sdk.models.subs


/**
 * Describes the weakness of a single pokemon, for example: 2x to Fire
 *
 */
data class CardWeakRes internal constructor(
    /**
     * @return Type the weakness is to
     */
    val type: String,
    /**
     * @return Descriptor of the weakness multiplier, including a leading x, for example 'x2'. May be null
     */
    val value: String
)