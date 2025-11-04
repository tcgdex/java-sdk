package net.tcgdex.sdk.models.subs

import com.google.gson.annotations.SerializedName
import net.tcgdex.sdk.internal.Model

/**
 * Pokémon TCG PricingCardMarket class
 */
data class PricingCardMarket internal constructor(
    /**
     * Indicate when is the last time it was fetched
     */
    val updated: String?,

    /**
     * Indicate the unit in which the card is sold
     */
    val unit: String?,

    /**
     * Average selling price (non-foil)
     */
    val avg: Float?,

    /**
     * Lowest market price (non-foil)
     */
    val low: Float?,

    /**
     * Trend price from charts (non-foil)
     */
    val trend: Float?,

    /**
     * Average price (last 24 hours)
     */
    val avg1: Float?,

    /**
     * 	Average price (last 7 days)
     */
    val avg7: Float?,

    /**
     * Average price (last 30 days)
     */
    val avg30: Float?,

    /**
     * Average selling price (foil)
     */
    @SerializedName("avg-holo")
    val avgHolo: Float?,

    /**
     * Lowest market price (foil)
     */
    @SerializedName("low-holo")
    val lowHolo: Float?,

    /**
     * Trend price from charts (foil)
     */
    @SerializedName("trend-holo")
    val trendHolo: Float?,

    /**
     * Average price (last 24 hours, foil)
     */
    @SerializedName("avg1-holo")
    val avg1Holo: Float?,

    /**
     * Average price (last 7 days, foil)
     */
    @SerializedName("avg7-holo")
    val avg7Holo: Float?,

    /**
     * Average price (last 30 days, foil)
     */
    @SerializedName("avg30-holo")
    val avg30Holo: Float?
) : Model()
