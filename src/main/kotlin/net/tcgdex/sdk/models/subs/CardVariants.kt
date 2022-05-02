package net.tcgdex.sdk.models.subs

/**
 * Card variants
 *
 * @property normal basic variant no special effects
 * @property reverse the card have some shine behind colored content
 * @property holo the card picture have some shine to it
 * @property firstEdition the card contains a First Edition Stamp (only Base serie)
 * @property wPromo the card has a wPromo stamp on it
 */
data class CardVariants(
    val normal: Boolean?,
    val reverse: Boolean?,
    val holo: Boolean?,
    val firstEdition: Boolean?,
    val wPromo: Boolean?
)
