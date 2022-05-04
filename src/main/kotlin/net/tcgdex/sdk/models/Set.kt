package net.tcgdex.sdk.models

import net.tcgdex.sdk.Extension
import net.tcgdex.sdk.Utils
import net.tcgdex.sdk.internal.Model
import net.tcgdex.sdk.models.subs.Legal
import net.tcgdex.sdk.models.subs.SetCardCount
import java.awt.image.BufferedImage

/**
 * Pokémon TCG Set class
 */
data class Set internal constructor(

    /**
     * Globally unique set ID
     */
    val id: String?,

    /**
     * the Set mame
     */
    val name: String?,

    /**
     * the Set Logo incomplete URL (use getLogoUrl/getLogo)
     */
    val logo: String?,

    /**
     * the Set Symbol imcomplete URL (use getSymbolUrl/getSymbol)
     */
    val symbol: String?,

    /**
     * the serie this set is a part of
     */
    val serie: SerieResume,

    /**
     * the TCG Online Code
     */
    val tcgOnline: String?,

    /**
     * the Set release date as yyyy-mm-dd
     */
    val releaseDate: String?,

    /**
     * the set legality (won't indicate if a card is banned)
     */
    val legal: Legal,

    /**
     * the number of card in the set
     */
    val cardCount: SetCardCount,

    /**
     * the cards contained in this set
     */
    val cards: List<CardResume>
) : Model() {

    /**
     * Get logo url
     *
     * @param extension
     * @return
     */
    fun getLogoUrl(extension: Extension): String? {
        if (this.logo == null) {
            return null
        }
        return "${this.logo}.${extension.value}"
    }

    /**
     * Get logo
     *
     * @param extension
     * @return
     */
    fun getLogo(extension: Extension): BufferedImage? {
        val logo = this.getLogoUrl(extension) ?: return null
        return Utils.downloadImage(logo)
    }

    /**
     * Get symbol url
     *
     * @param extension
     * @return
     */
    fun getSymbolUrl(extension: Extension): String? {
        if (this.symbol == null) {
            return null
        }
        return "${this.symbol}.${extension.value}"
    }

    /**
     * Get symbol
     *
     * @param extension
     * @return
     */
    fun getSymbol(extension: Extension): BufferedImage? {
        val symbol = this.getSymbolUrl(extension) ?: return null
        return Utils.downloadImage(symbol)
    }
}
