package net.tcgdex.sdk.models

import net.tcgdex.sdk.Extension
import net.tcgdex.sdk.Utils
import net.tcgdex.sdk.internal.Model
import java.awt.image.BufferedImage


/**
 * Serie Resume
 */
open class SerieResume internal constructor(

    /**
     * the Serie unique ID
     */
    val id: String,

    /**
     * the Serie name
     */
    val name: String,

    /**
     * the Serie Logo (basically also the first set logo)
     */
    val logo: String?
) : Model() {

    /**
     * Get the logo full url
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
     * Get the logo buffer
     *
     * @param format
     * @return
     */
    fun getLogo(format: Extension): BufferedImage? {
        val logo = this.getLogoUrl(format) ?: return null
        return Utils.downloadImage(logo)
    }

    /**
     * Get the full Serie
     *
     * @return the full serie if available
     */
    fun getFullSerie(): Serie? {
        return this.tcgdex.fetchSerie(this.id)
    }
}
