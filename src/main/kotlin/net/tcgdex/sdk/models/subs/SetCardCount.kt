package net.tcgdex.sdk.models.subs

/**
 * Set card count
 *
 * @property total total of number of cards
 * @property official number of cards officialy (on the bottom of each cards)
 * @property normal number of cards having a normal version
 * @property reverse number of cards having an reverse version
 * @property holo number of cards having an holo version
 * @property firstEd Number of possible cards
 */
data class SetCardCount (
    val total: Int,
    val official: Int,
    val normal: Int,
    val reverse: Int,
    val holo: Int,
    val firstEd: Int?
)
