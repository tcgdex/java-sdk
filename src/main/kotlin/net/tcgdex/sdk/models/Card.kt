package net.tcgdex.sdk.models

import net.tcgdex.sdk.Utils
import net.tcgdex.sdk.internal.Model
import net.tcgdex.sdk.models.subs.CardAbility
import net.tcgdex.sdk.models.subs.CardAttack
import net.tcgdex.sdk.models.subs.CardWeakRes
import java.awt.image.BufferedImage

/**
 * Full description of a card, including all information available about it
 *
 */
data class Card internal constructor(
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
    val image: String?,
    /**
     *
     * @return Card illustrator, may be null
     */
    val illustrator: String,

    /**
     *
     * @return Card rarity
     */
    val rarity: String,

    /**
     *
     * @return Card category
     */
    val category: String,
    private val hasNormalVariant: Boolean,
    private val hasReverseVariant: Boolean,
    private val hasHolo: Boolean,
    private val hasFirstEditionPic: Boolean,

    /**
     * @return Resume of the set the card belongs to
     */
    val set: SetResume,
    private val dexIDs: MutableList<Int>,

    /**
     * @return HP of the pokemon, will be null if the card is not a pokemon
     */
    val hp: Int?,

    /**
     * @return Types of the pokemon
     */
    val types: List<String?>?,

    /**
     *
     * @return Name of the pokemon this one evolves from
     */
    val evolveFrom: String,

    /**
     *
     * @return Card effect/description, may be null
     */
    val effect: String,

    /**
     *
     * @return Pokemon level, may be 'X', hence not an integer
     */
    val level: String,

    /**
     * @return Pokemon's stage, like 'Basic'
     */
    val stage: String,

    /**
     * @return Suffix, like 'V', may be null
     */
    val suffix: String,

    /**
     * @return Attacks the pokemon has. Empty for cards without attacks
     */
    val attacks: List<CardAttack>,

    /**
     * @return Weaknesses the pokemon has. Empty for cards without attacks
     */
    val cardWeakRes: List<CardWeakRes>,

    /**
     * @return Pokemon's abilities. May be empty if it doesn't have any, but never
     * null
     */
    val abilities: List<CardAbility>,

    /**
     * @return Card's retreat. Will be null for cards without retreat
     */
    val retreat: Int?,

    /**
     *
     * @return Card's regulation mark. May be null if unknown or doesn't exist
     */
    val regulationMark: String?
) : Model() {
    fun getImageUrl(quality: Quality, extension: Extension): String {
        return "${this.image}/${quality}.${extension}"
    }

    fun getImage(quality: Quality, extension: Extension): BufferedImage {
        return Utils.downloadImage(this.getImageUrl(quality, extension))
    }
}
