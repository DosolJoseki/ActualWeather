package com.home.joseki.actualweather.model

class WeatherItem {
    var clouds: Clouds? = null
    var dt: String? = null
    var wind: Wind? = null
    var sys: Sys? = null
    var snow: Snow? = null
    var weather: Array<WeatherDesc>? = null
    var dt_txt: String? = null
    var main: Main? = null
}