package net.tcgdex.sdk

/**
 * The different extension an image is available in
 */
enum class Extension(

    /**
     * the string representation of the extension
     */
    val value: String
) {

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
