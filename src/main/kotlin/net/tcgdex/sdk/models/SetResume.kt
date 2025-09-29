package net.tcgdex.sdk.models

import net.tcgdex.sdk.Extension
import net.tcgdex.sdk.Utils
import net.tcgdex.sdk.internal.Model
import net.tcgdex.sdk.models.subs.SetCardCountResume
import java.awt.image.BufferedImage

/**
 * Set resume
 */
data class SetResume internal constructor(

    /**
     * Globally unique set ID
     */
    val id: String,

    /**
     * the Set mame
     */
    val name: String,

    /**
     * the Set Logo incomplete URL (use getLogoUrl/getLogo)
     */
    val logo: String?,

    /**
     * the Set Symbol incomplete URL (use getSymbolUrl/getSymbol)
     */
    val symbol: String?,

    /**
     * the number of card in the set
     */
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

    /**
     * Get the full set
     *
     * @return the full set if available
     */
    fun getFullSet(): Set? {
        return this.tcgdex.fetchSet(this.id)
    }
}
