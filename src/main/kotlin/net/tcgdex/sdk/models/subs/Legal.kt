package net.tcgdex.sdk.models.subs

/**
 * Card Legality
 *
 * _note: cards are always legal in the ulimited tournament_
 *
 * @property standard card is legal in standard tournaments
 * @property expanded card is legal in expanded tournaments
 */
data class Legal(
    val standard: Boolean,
    val expanded: Boolean
)
