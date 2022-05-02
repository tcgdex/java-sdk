package net.tcgdex.sdk.models

/**
 * Image quality if applicable
 * (only cards does have quality selector)
 *
 * @property value the string representation of the quality
 */
enum class Quality(val value: String) {

    /**
     * A High quality image
     */
    HIGH("high"),

    /**
     * A Low quality image
     */
    LOW("low")
}
