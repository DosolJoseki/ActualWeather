package com.home.joseki.actualweather.model

import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp_kf")
    val tempKf: String = "",
    @SerializedName("humidity")
    val humidity: String = "",
    @SerializedName("pressure")
    val pressure: String = "pressure",
    @SerializedName("temp_max")
    val tempMax: String = "",
    @SerializedName("sea_level")
    val seaLevel: String = "",
    @SerializedName("temp_min")
    val tempMin: String = "",
    @SerializedName("temp")
    val temp: String = "",
    @SerializedName("grnd_level")
    val grndLevel: String = ""
)