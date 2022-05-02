package net.tcgdex.sdk.models

import net.tcgdex.sdk.internal.Model

/**
 * Class that handle a lot of Endpoints
 *
 * @property name the endpoint value
 * @property cards the cards that contains `name` in them
 * @constructor Create empty String endpoint
 */
data class StringEndpoint(
    val name: String,
    val cards: List<CardResume>
) : Model()
