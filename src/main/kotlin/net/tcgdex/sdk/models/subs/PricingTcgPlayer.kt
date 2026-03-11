package net.tcgdex.sdk.models.subs

import com.google.gson.annotations.SerializedName
import net.tcgdex.sdk.internal.Model

/**
 * Pokémon TCG PricingTcgPlayer class
 */
data class PricingTcgPlayer internal constructor(
    /**
     * Indicate when is the last time it was fetched
     */
    val updated: String,

    /**
     * Indicate the unit in which the card is sold
     */
    val unit: String,

    /**
     * Standard non-foil cards
     */
    val normal: PricingTcgPlayerVariant?,

    /**
     * Holofoil finish cards
     */
    val holoFoil: PricingTcgPlayerVariant?,

    /**
     * Reverse holofoil cards
     */
    @SerializedName("reverse-holofoil")
    val reverseHolofoil: PricingTcgPlayerVariant?,

    /**
     * First edition cards
     */
    @SerializedName("1st-edition")
    val firstEdition: PricingTcgPlayerVariant?,

    /**
     * First edition holofoil cards
     */
    @SerializedName("1st-edition-holofoil")
    val firstEditionHolofoil: PricingTcgPlayerVariant?,

    /**
     * Unlimited edition cards
     */
    val unlimited: PricingTcgPlayerVariant?,

    /**
     * Unlimited holofoil cards
     */
    @SerializedName("unlimited-holofoil")
    val unlimitedHolofoil: PricingTcgPlayerVariant?
) : Model()
