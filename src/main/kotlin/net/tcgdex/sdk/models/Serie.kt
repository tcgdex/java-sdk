package net.tcgdex.sdk.models

import net.tcgdex.sdk.Extension
import net.tcgdex.sdk.Utils
import net.tcgdex.sdk.internal.Model
import java.awt.image.BufferedImage

/**
 * Pokémon TCG Serie
 */
class Serie (

    /**
     * the list of sets the Serie contains
     */
    val sets: List<SetResume>,

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
     * @param extension the file extension you want to use
     * @return the full URL of the logo
     */
    fun getLogoUrl(extension: Extension): String? {
        if (this.logo == null) {
            return null
        }
        return "${this.logo}.${extension.value}"
    }

    /**
     * Get the logo buffer
     *
     * @param format the image format
     * @return a buffer containing the image
     */
    fun getLogo(format: Extension): BufferedImage? {
        val logo = this.getLogoUrl(format) ?: return null
        return Utils.downloadImage(logo)
    }
}
