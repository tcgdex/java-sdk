package net.tcgdex.sdk

import net.tcgdex.sdk.models.Card
import net.tcgdex.sdk.models.CardResume
import net.tcgdex.sdk.models.Serie
import net.tcgdex.sdk.models.SerieResume
import net.tcgdex.sdk.models.Set
import net.tcgdex.sdk.models.SetResume
import net.tcgdex.sdk.models.StringEndpoint

/**
 * The main TCGdex SDK instance
 *
 * @constructor Create the TCGdex Instance in the specific language
 */
class TCGdex(
    /**
     * the language you want to use, values: [en,fr,es,de,pt,it]
     */
    var language: String
) {

    /**
     * The API Endpoint you want to use
     */
    var URI = "https://api.tcgdex.net/v2"

    /**
     * Fetch every Pokémon cards
     *
     * _note: take some time as there is around 13k-15k cards depending on the language_
     *
     * @return the list of Pokémon Cards
     */
    fun fetchCards(): Array<CardResume>? {
        return this.fetch(Array<CardResume>::class.java, "cards")
    }

    /**
     * Fetch a specific card
     *
     * @param card the card ID
     * @return The card
     */
    fun fetchCard(cardId: String): Card? {
        return this.fetch(Card::class.java, "cards", cardId)
    }

    /**
     * Fetch a specific card by its set and local IDs
     *
     * @param setId the set ID/name
     * @param cardId the card local ID
     * @return the card you want
     */
    fun fetchCard(setId: String, cardId: String): Card? {
        return this.fetch(Card::class.java, "sets", setId, cardId)
    }

    /**
     * Fetch every pokémon TCG Sets
     *
     * @return the list of Pokémon TCG sets
     */
    fun fetchSets(): Array<SetResume>? {
       return this.fetch(Array<SetResume>::class.java, "sets")
    }

    /**
     * Fetch a specific set
     *
     * @param set the set you want to fetch (you can use the Set ID or name)
     * @return The set you searched
     */
    fun fetchSet(set: String): Set? {
       return this.fetch(Set::class.java, "sets", set)
    }

    /**
     * Fetch every pokémon TCG Series
     *
     * @return the list of Pokémon TCG Series
     */
    fun fetchSeries(): Array<SerieResume>? {
        return this.fetch(Array<SerieResume>::class.java, "series")
    }

    /**
     * Fetch a specific serie
     *
     * @param serie the serie you want to fetch (you can use the Serie ID or name)
     * @return The serie you searched
     */
    fun fetchSerie(serie: String): Serie? {
        return this.fetch(Serie::class.java, "series", serie)
    }

    /**
     * Fetch evey variants it is possible to have
     *
     * @return the list of evey variants it is possible to have
     */
    fun fetchVariants(): Array<String>? {
        return this.fetch(Array<String>::class.java, "variants")
    }

    /**
     * Fetch cards by variant
     *
     * @param variant the variant you want to filter by
     * @return a StringEndpoint containing the cards with the specified variant
     */
    fun fetchVariant(variant: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "variants", variant)
    }

    /**
     * Fetch evey Trainer Types it is possible to have
     *
     * @return the list of evey Trainer Types it is possible to have
     */
    fun fetchTrainerTypes(): Array<String>? {
        return this.fetch(Array<String>::class.java, "trainer-types")
    }

    /**
     * Fetch cards by trainer type
     *
     * @param type the trainer type you want to filter by
     * @return a StringEndpoint containing the cards with the specified trainer type
     */
    fun fetchTrainerType(type: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "trainer-types", type)
    }

    /**
     * Fetch evey suffixes it is possible to have
     *
     * @return the list of evey suffixes it is possible to have
     */
    fun fetchSuffixes(): Array<String>? {
        return this.fetch(Array<String>::class.java, "suffixes")
    }

    /**
     * Fetch cards by suffix
     *
     * @param suffix the suffix you want to filter by
     * @return a StringEndpoint containing the cards with the specified suffix
     */
    fun fetchSuffix(suffix: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "suffixes", suffix)
    }

    /**
     * Fetch evey stages it is possible to have
     *
     * @return the list of evey stages it is possible to have
     */
    fun fetchStages(): Array<String>? {
        return this.fetch(Array<String>::class.java, "stages")
    }

    /**
     * Fetch cards by stage
     *
     * @param stage the stage you want to filter by
     * @return a StringEndpoint containing the cards with the specified stage
     */
    fun fetchStage(stage: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "stages", stage)
    }

    /**
     * Fetch evey Regulation Marks it is possible to have
     *
     * @return the list of evey Regulation Marks it is possible to have
     */
    fun fetchRegulationMarks(): Array<String>? {
        return this.fetch(Array<String>::class.java, "regulation-marks")
    }

    /**
     * Fetch cards by regulation mark
     *
     * @param regulationMark the regulation mark you want to filter by
     * @return a StringEndpoint containing the cards with the specified regulation mark
     */
    fun fetchRegulationMark(regulationMark: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "regulation-marks", regulationMark)
    }

    /**
     * Fetch evey Energy Types it is possible to have
     *
     * @return the list of evey Energy Types it is possible to have
     */
    fun fetchEnergyTypes(): Array<String>? {
        return this.fetch(Array<String>::class.java, "energy-types")
    }

    /**
     * Fetch cards by Energy type
     *
     * @param energyType the Energy type you want to filter by
     * @return a StringEndpoint containing the cards with the specified Energy type
     */
    fun fetchEnergyType(energyType: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "energy-types", energyType)
    }

    /**
     * Fetch evey Pokédex IDS it is possible to have
     *
     * @return the list of evey Pokédex IDS it is possible to have
     */
    fun fetchDexIds(): Array<String>? {
        return this.fetch(Array<String>::class.java, "dex-ids")
    }

    /**
     * Fetch cards by pokédex ID
     *
     * @param dexId the pokédex ID you want to filter by
     * @return a StringEndpoint containing the cards with the specified pokédex ID
     */
    fun fetchDexId(dexId: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "dex-ids", dexId)
    }

    /**
     * Fetch evey types it is possible to have
     *
     * @return the list of evey types it is possible to have
     */
    fun fetchTypes(): Array<String>? {
        return this.fetch(Array<String>::class.java, "types")
    }

    /**
     * Fetch cards by type
     *
     * @param type the type you want to filter by
     * @return a StringEndpoint containing the cards with the specified type
     */
    fun fetchType(type: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "types", type)
    }

    /**
     * Fetch evey categories it is possible to have
     *
     * @return the list of evey categories it is possible to have
     */
    fun fetchCategories(): Array<String>? {
        return this.fetch(Array<String>::class.java, "categories")
    }

    /**
     * Fetch cards by category
     *
     * @param category the category you want to filter by
     * @return a StringEndpoint containing the cards with the specified category
     */
    fun fetchCategory(category: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "categories", category)
    }

    /**
     * Fetch evey retreat count it is possible to have
     *
     * @return the list of evey retreat count it is possible to have
     */
    fun fetchRetreats(): Array<String>? {
        return this.fetch(Array<String>::class.java, "retreats")
    }

    /**
     * Fetch cards by retreat
     *
     * @param retreat the retreat count you want to filter by
     * @return a StringEndpoint containing the cards with the specified retreat count
     */
    fun fetchRetreat(retreat: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "retreats", retreat)
    }

    /**
     * Fetch every Card rarities you can have (in your language)
     *
     * @return the list of Card rarities you can have (in your language)
     */
    fun fetchRarities(): Array<String>? {
        return this.fetch(Array<String>::class.java, "rarities")
    }

    /**
     * Fetch cards by rarity
     *
     * @param rarity the rarity you want to filter by (language specific)
     * @return a StringEndpoint containing the cards with the specified rarity
     */
    fun fetchRarity(rarity: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "rarities", rarity)
    }

    /**
     * Fetch every cards illustrators
     *
     * @return the list of ilustrators
     */
    fun fetchIllustrators(): Array<String>? {
        return this.fetch(Array<String>::class.java, "illustrators")
    }

    /**
     * Fetch cards by illustrator
     *
     * @param illustrator the illustrator you want to filter by
     * @return a StringEndpoint containing the cards with the specified illustrator
     */
    fun fetchIllustrator(illustrator: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "illustrators", illustrator)
    }

    /**
     * Fetch the list of possible value the HP field can take
     *
     * @return the list of possible value the HP field can take
     */
    fun fetchHPs(): Array<String>? {
        return this.fetch(Array<String>::class.java, "hp")
    }

    /**
     * Fetch cards by hp
     *
     * @param hp the hp count you want to filter by
     * @return a StringEndpoint containing the cards with the specified hp count
     */
    fun fetchHP(hp: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "hp", hp)
    }

    private fun <T> fetch(cls: Class<T>, vararg path: String): T? {
        return Utils.fetch(this, "$URI/$language/${
            path.joinToString("/") {
                it.replace(
                    " ",
                    "%20"
                )
            }
        }", cls)
    }
}
