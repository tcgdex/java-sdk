package net.tcgdex.sdk.models


/**
 * Contains all information describing a series, an overarching group of sets, for example XY
 *
 */
open class SerieResume internal constructor(
    /**
     * @return Serie unique ID
     */
    val id: String?,
    /**
     * @return Serie name
     */
    val name: String?
)