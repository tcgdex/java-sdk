package net.tcgdex.sdk.models

import net.tcgdex.sdk.internal.Model
import net.tcgdex.sdk.models.subs.PricingCardMarket
import net.tcgdex.sdk.models.subs.PricingTcgPlayer

/**
 * Pokémon TCG Pricing class
 */
data class Pricing internal constructor(
    val tcgplayer: PricingTcgPlayer?,
    val cardmarket: PricingCardMarket?
) : Model()
