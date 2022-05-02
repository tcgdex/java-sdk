package net.tcgdex.sdk.models

import net.tcgdex.sdk.Utils
import net.tcgdex.sdk.internal.Model
import net.tcgdex.sdk.models.subs.SetCardCountResume
import java.awt.image.BufferedImage

/**
 * Set resume
 *
 * @property id Globally unique set ID
 * @property name the Set mame
 * @property logo the Set Logo incomplete URL (use getLogoUrl/getLogo)
 * @property symbol the Set Symbol imcomplete URL (use getSymbolUrl/getSymbol)
 * @property cardCount the number of card in the set
 */
data class SetResume internal constructor(

    val id: String,

    val name: String,

    val logo: String?,

    val symbol: String?,

    val cardCount: SetCardCountResume
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

    /**
     * Get the full set
     *
     * @return the full set if available
     */
    fun getFullSet(): Set? {
        return this.tcgdex.fetchSet(this.id)
    }
}
