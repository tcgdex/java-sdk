package net.tcgdex.sdk

import net.tcgdex.sdk.models.*
import net.tcgdex.sdk.models.Set

class TCGdex(
    var language: String
) {

    private val URI = "https://api.tcgdex.net/v2"

    fun fetchCards(): Array<CardResume>? {
        return this.fetch(Array<CardResume>::class.java, "cards")
    }

    fun fetchCard(cardId: String): Card? {
        return this.fetch(Card::class.java, "cards", cardId)
    }

    fun fetchCard(setId: String, cardId: String): Card? {
        return this.fetch(Card::class.java, "sets", setId, cardId)
    }

   fun fetchSets(): Array<SetResume>? {
       return this.fetch(Array<SetResume>::class.java, "sets")
   }

   fun fetchSet(set: String): Set? {
       return this.fetch(Set::class.java, "sets", set)
   }

    fun fetchSeries(): Array<SerieResume>? {
        return this.fetch(Array<SerieResume>::class.java, "series")
    }

    fun fetchSerie(serie: String): Serie? {
        return this.fetch(Serie::class.java, "series", serie)
    }

    fun fetchVariants(): Array<String>? {
        return this.fetch(Array<String>::class.java, "variants")
    }
    fun fetchVariant(variant: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "variants", variant)
    }

    fun fetchTrainerTypes(): Array<String>? {
        return this.fetch(Array<String>::class.java, "trainer-types")
    }
    fun fetchTrainerType(type: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "trainer-types", type)
    }

    fun fetchSuffixes(): Array<String>? {
        return this.fetch(Array<String>::class.java, "suffixes")
    }
    fun fetchSuffix(suffix: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "suffixes", suffix)
    }

    fun fetchStages(): Array<String>? {
        return this.fetch(Array<String>::class.java, "stages")
    }
    fun fetchStage(stage: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "stages", stage)
    }

    fun fetchRegulationMarks(): Array<String>? {
        return this.fetch(Array<String>::class.java, "regulation-marks")
    }
    fun fetchRegulationMark(regulationMark: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "regulation-marks", regulationMark)
    }

    fun fetchEnergyTypes(): Array<String>? {
        return this.fetch(Array<String>::class.java, "energy-types")
    }
    fun fetchEnergyType(energyType: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "energy-types", energyType)
    }

    fun fetchDexIds(): Array<String>? {
        return this.fetch(Array<String>::class.java, "dex-ids")
    }
    fun fetchDexId(dexId: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "dex-ids", dexId)
    }

    fun fetchTypes(): Array<String>? {
        return this.fetch(Array<String>::class.java, "types")
    }
    fun fetchType(type: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "types", type)
    }

    fun fetchCategories(): Array<String>? {
        return this.fetch(Array<String>::class.java, "categories")
    }
    fun fetchCategory(category: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "categories", category)
    }

    fun fetchRetreats(): Array<String>? {
        return this.fetch(Array<String>::class.java, "categories")
    }
    fun fetchRetreat(retreat: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "retreats", retreat)
    }

    fun fetchRarities(): Array<String>? {
        return this.fetch(Array<String>::class.java, "rarities")
    }
    fun fetchRarity(rarity: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "rarities", rarity)
    }

    fun fetchIllustrators(): Array<String>? {
        return this.fetch(Array<String>::class.java, "illustrators")
    }
    fun fetchIllustrator(illustrator: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "illustrators", illustrator)
    }

    fun fetchHPs(): Array<String>? {
        return this.fetch(Array<String>::class.java, "hp")
    }
    fun fetchHP(hp: String): StringEndpoint? {
        return this.fetch(StringEndpoint::class.java, "hp", hp)
    }

    private fun <T> fetch(cls: Class<T>, vararg path: String): T? {
        return Utils.fetch("$URI/$language/${path.map { it.replace(" ", "%20") }.joinToString("/")}", cls)
    }
}
