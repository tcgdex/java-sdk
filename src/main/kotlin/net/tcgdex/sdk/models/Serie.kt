package net.tcgdex.sdk.models

import net.tcgdex.sdk.Utils
import net.tcgdex.sdk.internal.Model
import java.awt.image.BufferedImage

/**
 * Detailed info regarding a series, including which sets it includes
 *
 */
class Serie (
    /**
     * @return Resumes of the sets part of this series
     */
    val sets: List<SetResume>,
    /**
     * @return Serie unique ID
     */
    val id: String,
    /**
     * @return Serie name
     */
    val name: String,

    val logo: String?
) : Model() {
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
}
