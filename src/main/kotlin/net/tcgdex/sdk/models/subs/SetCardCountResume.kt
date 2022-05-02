package net.tcgdex.sdk.models.subs

/**
 * Set card count resume
 *
 * @property total total of number of cards
 * @property official number of cards officialy (on the bottom of each cards)
 */
data class SetCardCountResume (
    val total: Int,
    val official: Int
)
