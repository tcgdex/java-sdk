package net.tcgdex.sdk

import com.google.gson.Gson
import net.tcgdex.sdk.internal.CacheEntry
import net.tcgdex.sdk.internal.Model
import java.awt.image.BufferedImage
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import java.time.LocalDateTime
import javax.imageio.ImageIO

object Utils {
    /**
     * Request Time to Live
     * in minutes
     */
    var ttl: Long = 60

    /**
     * requests cache
     */
    private val cache: HashMap<String, CacheEntry<String>> = HashMap()

    private val gson = Gson()

    /**
     * fetch from the API
     *
     * @param tcgdex the TCGdex instance to link with it
     * @param url the url to fetch from
     * @param cls the Class to build the response into
     *
     * @return an initialized cls or null
     */
    fun <T> fetch(tcgdex: TCGdex, url: String, cls: Class<T>): T? {
        var entry = this.cache[url]
        val now = LocalDateTime.now().minusMinutes(ttl)
        if (entry == null || entry.time.isBefore(now)) {
            val req = URL(url).openConnection()
            req.setRequestProperty("user-agent", "@tcgdex/java-sdk")

            val br = BufferedReader(InputStreamReader(req.getInputStream()));
            var txt = ""
            var line = br.readLine()
            while (line != null)
            {
                txt += line
                line = br.readLine()
            }

            entry = CacheEntry(txt)

            this.cache[url] = entry
        }

        try {
            val model = gson.fromJson<T>(
                entry.value, cls
            )
            if (model is Model) {
                model.tcgdex = tcgdex
            }
            return model
        } catch (e: IOException) {
            return null
        }
    }

    /**
     * download an image from the internet
     *
     * @param path the url to the image
     *
     * @return the download image buffer
     */
    fun downloadImage(path: String): BufferedImage {
        return ImageIO.read(URL(path))
    }
}
