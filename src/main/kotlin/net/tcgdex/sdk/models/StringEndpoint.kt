package net.tcgdex.sdk.models

import net.tcgdex.sdk.internal.Model

/**
 * Generix class that handle a lot of Endpoints
 *
 * @constructor Create empty String endpoint
 */
data class StringEndpoint(
    /**
     * the endpoint value
     */
    val name: String,

    /**
     * the cards that contain `name` in them
     */
    val cards: List<CardResume>
) : Model()
