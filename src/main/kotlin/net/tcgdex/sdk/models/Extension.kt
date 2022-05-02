package net.tcgdex.sdk.models

/**
 * The different extension an image is available in
 *
 * @property value the string representation of the set
 */
enum class Extension(val value: String) {

    /**
     * .png image, with transparent background
     */
    PNG("png"),

    /**
     * .jpg image, with white background
     */
    JPG("jpg"),

    /**
     * .webp image, with transparent background
     */
    WEBP("webp")
}
