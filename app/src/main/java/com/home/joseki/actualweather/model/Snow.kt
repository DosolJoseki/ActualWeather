package com.home.joseki.actualweather.model
import com.google.gson.annotations.SerializedName

class Snow {
    @SerializedName("3h")
    val h: String? = null

    override fun toString(): String {
        return "ClassPojo [3h = $h]"
    }
}