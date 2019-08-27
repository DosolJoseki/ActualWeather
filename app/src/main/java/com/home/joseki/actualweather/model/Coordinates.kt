package com.home.joseki.actualweather.model

import com.google.gson.annotations.SerializedName

data class Coordinates(
    @SerializedName("lon")
    val lon: String = "",
    @SerializedName("lat")
    val lat: String = ""
)