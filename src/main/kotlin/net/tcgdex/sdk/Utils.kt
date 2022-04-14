package net.tcgdex.sdk

import com.google.gson.Gson
import net.tcgdex.sdk.internal.CacheEntry
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

	private val cache: HashMap<String, CacheEntry<String>> = HashMap()

	private val gson = Gson()

	fun <T> fetch(url: String, cls: Class<T>): T? {
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
            return gson.fromJson(
                entry.value, cls
            )
        } catch (e: IOException) {
            return null
        }
	}

    fun downloadImage(path: String): BufferedImage {
        return ImageIO.read(URL(path))
    }
}
