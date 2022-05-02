package net.tcgdex.sdk.models

import net.tcgdex.sdk.Utils
import net.tcgdex.sdk.internal.Model
import net.tcgdex.sdk.models.subs.Legal
import net.tcgdex.sdk.models.subs.SetCardCount
import java.awt.image.BufferedImage

/**
 * Pokémon TCG Set class
 *
 * @property id Globally unique set ID
 * @property name the Set mame
 * @property logo the Set Logo incomplete URL (use getLogoUrl/getLogo)
 * @property symbol the Set Symbol imcomplete URL (use getSymbolUrl/getSymbol)
 * @property serie the serie this set is a part of
 * @property tcgOnline the TCG Online Code
 * @property releaseDate the Set release date as yyyy-mm-dd
 * @property legal the set legality (won't indicate if a card is banned)
 * @property cardCount the number of card in the set
 * @property cards the cards contained in this set
 */
data class Set internal constructor(
    val id: String?,
    val name: String?,
    val logo: String?,
    val symbol: String?,

    val serie: SerieResume,
    val tcgOnline: String?,
    val releaseDate: String?,
    val legal: Legal,
    val cardCount: SetCardCount,
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
        return "${this.logo}.${extension}"
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
        return "${this.symbol}.${extension}"
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
