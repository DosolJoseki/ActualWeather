package com.home.joseki.actualweather.model

import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("speed")
    val speed: String = "",
    @SerializedName("deg")
    val deg: String = ""
)