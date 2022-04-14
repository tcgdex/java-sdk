package net.tcgdex.sdk

import java.io.IOException
import kotlin.test.Test
import kotlin.test.BeforeTest
import kotlin.test.assertNotNull

class APITest {
    private lateinit var api: TCGdex
    @BeforeTest
    fun initAPI() {
        api = TCGdex("en")
    }

    @Test
    @Throws(IOException::class)
    fun testFullCardInfo() {
        assertNotNull(api.fetchCard("swsh3-136"))
        assertNotNull(api.fetchCard("swsh3", "136"))
        assertNotNull(api.fetchSet("swsh3"))
        assertNotNull(api.fetchSets())
        assertNotNull(api.fetchSerie("swsh"))
        assertNotNull(api.fetchSeries())
        assertNotNull(api.fetchTypes())
        assertNotNull(api.fetchType("Colorless"))
        assertNotNull(api.fetchRetreats())
        assertNotNull(api.fetchRetreat("1"))
        assertNotNull(api.fetchRarities())
        assertNotNull(api.fetchRarity("Uncommon"))
        assertNotNull(api.fetchIllustrators())
        assertNotNull(api.fetchIllustrator("tetsuya koizumi"))
        assertNotNull(api.fetchHPs())
        assertNotNull(api.fetchHP("110"))
        assertNotNull(api.fetchCategories())
        assertNotNull(api.fetchCategory("Pokemon"))
        assertNotNull(api.fetchDexIds())
        assertNotNull(api.fetchDexId("162"))
        assertNotNull(api.fetchEnergyTypes())
        assertNotNull(api.fetchEnergyType("Special"))
        assertNotNull(api.fetchRegulationMarks())
        assertNotNull(api.fetchRegulationMark("D"))
        assertNotNull(api.fetchStages())
        assertNotNull(api.fetchStage("Basic"))
        assertNotNull(api.fetchSuffixes())
        assertNotNull(api.fetchSuffix("EX"))
        assertNotNull(api.fetchTrainerTypes())
        assertNotNull(api.fetchTrainerType("Tool"))
        assertNotNull(api.fetchVariants())
        assertNotNull(api.fetchVariant("holo"))
    }
}
