package net.tcgdex.sdk.models

import net.tcgdex.sdk.Extension
import net.tcgdex.sdk.Quality
import net.tcgdex.sdk.Utils
import net.tcgdex.sdk.internal.Model
import net.tcgdex.sdk.models.subs.CardAbility
import net.tcgdex.sdk.models.subs.CardAttack
import net.tcgdex.sdk.models.subs.CardItem
import net.tcgdex.sdk.models.subs.CardVariants
import net.tcgdex.sdk.models.subs.CardWeakRes
import net.tcgdex.sdk.models.subs.Legal
import java.awt.image.BufferedImage
/**
 * Pokémon TCG Card, It contains every informations about a specific card
 */
data class Card internal constructor(

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
	val image: String?,


	/**
	 * Card illustrator
	 */
	val illustrator: String?,

	/**
	 * Card rarity
	 */
	val rarity: String,

	/**
	 * Card category
	 */
	val category: String,

	/**
	 * The card possible variants
	 */
	val variants: CardVariants?,

	/**
	 * Resume of the set the card belongs to
	 */
	val set: SetResume,


	/**
	 * the Pokémon Pokédex IDs (multiple if multiple pokémon appears on the card)
	 */
	val dexIDs: List<Int>?,

	/**
	 * HP of the pokemon
	 */
	val hp: Int?,

	/**
	 * Types of the pokemon (multiple because some have multiple in the older sets)
	 */
	val types: List<String>?,

	/**
	 * Name of the pokemon this one evolves from
	 */
	val evolveFrom: String?,

	/**
	 * the Pokémon Pokédex like description
	 */
	val description: String?,

	/**
	 *the Pokémon Level (can be "X" if the card is of level X)
	 */
	val level: String?,

	/**
     * the Pokémon Stage (changes depending on the API language)
	 */
	val stage: String?,

	/**
     * the Pokémon Suffix (changes depending on the API language)
	 */
	val suffix: String?,

	/**
     * the Item the Pokémon have
	 */
	val item: CardItem?,

	/**
     * the Card abilities (some cards have multiple abilities)
	 */
	val abilities: List<CardAbility>,

	/**
     * the Card Attacks
	 */
	val attacks: List<CardAttack>,

	/**
	 *
     * the Pokémon Weaknesses
	 */
	val weaknesses: List<CardWeakRes>,

	/**
	 *
     * the Pokémon Resistances
	 */
	val resistances: List<CardWeakRes>,

	/**
	 *
     * the Pokémon retreat Cost
	 */
	val retreat: Int?,


	/**
	 * effect the Card Effect (Trainer/Energy only)
	 */
	val effect: String?,

	/**
	 * the trainer sub type (changes depending on the API language)
	 */
	val trainerType: String?,

	/**
	 * the energy sub type (changes depending on the API language)
	 */
	val energyType: String?,

	/**
	 * the Card Regulation mark
	 */
	val regulationMark: String?,

	/**
	 * the card ability to be played in tournaments
	 */
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
