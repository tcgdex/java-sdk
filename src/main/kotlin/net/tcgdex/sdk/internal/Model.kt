package net.tcgdex.sdk.internal

import com.google.gson.Gson
import net.tcgdex.sdk.TCGdex

abstract class Model {
    /**
     * Give you a string representation of the Model
     *
     * @return the model data as JSON
     */
    override fun toString(): String {
        val gson = Gson()
        return gson.toJson(this)
    }

    public lateinit var tcgdex: TCGdex
}
