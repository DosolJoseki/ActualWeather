package com.home.joseki.actualweather.model

import com.google.gson.annotations.SerializedName

data class WeatherDesc(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("icon")
    val icon: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("main")
    val main: String = ""
)