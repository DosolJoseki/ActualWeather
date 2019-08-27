package com.home.joseki.actualweather.model
import com.google.gson.annotations.SerializedName

data class Snow(
    @SerializedName("3h")
    private val h: String = ""
)