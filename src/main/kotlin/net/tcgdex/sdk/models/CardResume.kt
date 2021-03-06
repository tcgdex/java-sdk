package net.tcgdex.sdk.models

import net.tcgdex.sdk.Extension
import net.tcgdex.sdk.Quality
import net.tcgdex.sdk.Utils
import net.tcgdex.sdk.internal.Model
import java.awt.image.BufferedImage

/**
 * Card Resume class, contains basic informations about a specific card
 *
 * to get the full card you can use the `getFullCard()` function
 */
data class CardResume internal constructor(

    /**
     * Globally unique card ID based on the set ID and the cards ID within the set
     */
    val id: String,

    /**
     * ID indexing this card within its set, usually just its number
     */
    val localId: String,

    /**
     * Card name
     */
    val name: String,

    /**
     * Card image url without the extension and quality
     */
    val image: String?
) : Model() {

    /**
     * the the Card Image full URL
     *
     * @param quality the quality you want your image to be in
     * @param extension extension you want you image to be
     * @return the full card URL with the extension and quality
     */
    fun getImageUrl(quality: Quality, extension: Extension): String {
        return "${this.image}/${quality}.${extension.value}"
    }

    /**
     * Get image buffer
     *
     * @param quality the quality you want your image to be in
     * @param format extension you want you image to be
     * @return the full card Buffer in the format you want
     */
    fun getImage(quality: Quality, format: Extension): BufferedImage {
        return Utils.downloadImage(this.getImageUrl(quality, format))
    }

    /**
     * Get the full Card
     *
     * @return the full card if available
     */
    fun getFullCard(): Card? {
        return this.tcgdex.fetchCard(this.id)
    }
}
