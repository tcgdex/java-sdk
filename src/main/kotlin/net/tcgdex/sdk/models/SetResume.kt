package net.tcgdex.sdk.models

import net.tcgdex.sdk.Utils
import net.tcgdex.sdk.models.subs.SetCardCountResume
import java.awt.image.BufferedImage

/**
 * Contains all information describing a set of cards
 *
 */
data class SetResume internal constructor(
    /**
     * @return Set unique ID
     */
    val id: String?,
    /**
     * @return Set name
     */
    val name: String?,
    /**
     * @return Set logo URL, may be null
     */
    val logo: String?,
    /**
     * @return Set symbol URL, may be null
     */
    val symbol: String?,

    val cardCount: SetCardCountResume
) {
    fun getLogoUrl(extension: Extension): String? {
        if (this.logo == null) {
            return null
        }
        return "${this.logo}.${extension}"
    }

    fun getLogo(extension: Extension): BufferedImage? {
        val logo = this.getLogoUrl(extension) ?: return null
        return Utils.downloadImage(logo)
    }

    fun getSymbolUrl(extension: Extension): String? {
        if (this.symbol == null) {
            return null
        }
        return "${this.symbol}.${extension}"
    }

    fun getSymbol(extension: Extension): BufferedImage? {
        val symbol = this.getSymbolUrl(extension) ?: return null
        return Utils.downloadImage(symbol)
    }
}
