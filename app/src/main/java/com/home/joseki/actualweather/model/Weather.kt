package com.home.joseki.actualweather.model

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("message")
    val message: String = "",
    @SerializedName("cnt")
    val cnt: String = "",
    @SerializedName("cod")
    val cod: String = "",
    @SerializedName("list")
    val list: List<WeatherItem>? = null,
    @SerializedName("city")
    val city: City = City()
)