package net.tcgdex.sdk.models

import net.tcgdex.sdk.Utils
import net.tcgdex.sdk.internal.Model
import net.tcgdex.sdk.models.subs.*
import java.awt.image.BufferedImage
/**
 * Pokémon TCG Card, It contains every informations about a specific card
 *
 * @property id Globally unique card ID based on the set ID and the cards ID within the set
 * @property localId ID indexing this card within its set, usually just its number
 * @property name Card name
 * @property image Card image url without the extension and quality
 * @property illustrator Card illustrator
 * @property rarity Card rarity
 * @property category Card category
 * @property variants The card possible variants
 * @property set Resume of the set the card belongs to
 * @property dexIDs the Pokémon Pokédex IDs (multiple if multiple pokémon appears on the card)
 * @property hp HP of the pokemon
 * @property types Types of the pokemon (multiple because some have multiple in the older sets)
 * @property evolveFrom Name of the pokemon this one evolves from
 * @property description the Pokémon Pokédex like description
 * @property level the Pokémon Level (can be "X" if the card is of level X)
 * @property stage the Pokémon Stage (changes depending on the API language)
 * @property suffix the Pokémon Suffix (changes depending on the API language)
 * @property item the Item the Pokémon have
 * @property abilities the Card abilities (some cards have multiple abilities)
 * @property attacks the Card Attacks
 * @property weaknesses the Pokémon Weaknesses
 * @property resistances the Pokémon Resistances
 * @property retreat the Pokémon retreat Cost
 * @property effect the Card Effect (Trainer/Energy only)
 * @property trainerType the trainer sub type (changes depending on the API language)
 * @property energyType the energy sub type (changes depending on the API language)
 * @property regulationMark the Card Regulation mark
 * @property legal the card ability to be played in tournaments
 */
data class Card internal constructor(
    val id: String,
    val localId: String,
    val name: String,
    val image: String?,

    val illustrator: String?,
    val rarity: String,
    val category: String,
    val variants: CardVariants?,
    val set: SetResume,

    private val dexIDs: List<Int>?,
    val hp: Int?,
    val types: List<String>?,
    val evolveFrom: String?,
    val description: String?,
    val level: String?,
    val stage: String?,
    val suffix: String?,
    val item: CardItem?,
    val abilities: List<CardAbility>,
    val attacks: List<CardAttack>,
    val weaknesses: List<CardWeakRes>,
    val resistances: List<CardWeakRes>,
    val retreat: Int?,

    val effect: String?,
    val trainerType: String?,
    val energyType: String?,
    val regulationMark: String?,
    val legal: Legal
) : Model() {

    /**
     * the Card Image full URL
     *
     * @param quality the quality you want your image to be in
     * @param extension extension you want you image to be
     * @return the full card URL with the extension and quality
     */
    fun getImageUrl(quality: Quality, extension: Extension): String {
        return "${this.image}/${quality.value}.${extension}"
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
}
