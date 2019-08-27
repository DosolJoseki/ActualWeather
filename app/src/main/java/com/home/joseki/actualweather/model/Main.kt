package com.home.joseki.actualweather.model

import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp_kf")
    private val tempKf: String = "",
    @SerializedName("humidity")
    private val humidity: String = "",
    @SerializedName("pressure")
    private val pressure: String = "pressure",
    @SerializedName("temp_max")
    private val tempMax: String = "",
    @SerializedName("sea_level")
    private val seaLevel: String = "",
    @SerializedName("temp_min")
    private val tempMin: String = "",
    @SerializedName("temp")
    private val temp: String = "",
    @SerializedName("grnd_level")
    private val grndLevel: String = ""
)