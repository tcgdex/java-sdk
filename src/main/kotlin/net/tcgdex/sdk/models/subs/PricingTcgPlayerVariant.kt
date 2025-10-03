package net.tcgdex.sdk.models.subs

/**
 * Pokémon TCG PricingTcgPlayerVariant class
 */
data class PricingTcgPlayerVariant internal constructor(
    /**
     * Lowest available price
     */
    val lowPrice: Float?,

    /**
     * Median market price
     */
    val midPrice: Float?,

    /**
     * Highest available price
     */
    val highPrice: Float?,

    /**
     * Current market price
     */
    val marketPrice: Float?,

    /**
     * Lowest direct seller price
     */
    val directLowPrice: Float?
)
