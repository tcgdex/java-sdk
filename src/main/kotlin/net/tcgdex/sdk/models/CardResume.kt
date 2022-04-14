package net.tcgdex.sdk.models

import net.tcgdex.sdk.Utils
import net.tcgdex.sdk.internal.Model
import java.awt.image.BufferedImage

/**
 * Core information to describe a single card
 *
 */
data class CardResume internal constructor(
    /**
     * @return Globally unique card ID based on the set ID and the cards ID within the set
     */
    val id: String,
    /**
     * @return ID indexing this card within its set, usually just its number
     */
    val localId: String?,
    /**
     *
     * @return Card name
     */
    val name: String?,
    /**
     *
     * @return Card image, can be null
     */
    val image: String?
) : Model() {
    fun getImageUrl(quality: Quality, extension: Extension): String {
        return "${this.image}/${quality}.${extension}"
    }

    fun getImage(quality: Quality, extension: Extension): BufferedImage {
        return Utils.downloadImage(this.getImageUrl(quality, extension))
    }
}
