package com.home.joseki.actualweather.model

import com.google.gson.annotations.SerializedName

data class WeatherItem(
    @SerializedName("clouds")
    val clouds: Clouds = Clouds(),
    @SerializedName("dt")
    val dt: String = "",
    @SerializedName("wind")
    val wind: Wind = Wind(),
    @SerializedName("sys")
    val sys: Sys = Sys(),
    @SerializedName("snow")
    val snow: Snow = Snow(),
    @SerializedName("weather")
    val weather: List<WeatherDesc>? = null, //Array
    @SerializedName("dt_txt")
    val dtTxt: String = "",
    @SerializedName("main")
    val main: Main = Main()
)