package net.tcgdex.sdk

/**
 * Image quality if applicable
 * (only cards does have quality selector)
 */
enum class Quality(

    /**
     * the string representation of the quality
     */
    val value: String
) {

    /**
     * A High quality image
     */
    HIGH("high"),

    /**
     * A Low quality image
     */
    LOW("low")
}
