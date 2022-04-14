package net.tcgdex.sdk.internal

import com.google.gson.Gson

abstract class Model {
    override fun toString(): String {
        val gson = Gson()
        return gson.toJson(this)
    }
}
