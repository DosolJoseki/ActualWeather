package com.home.joseki.actualweather.model

import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all")
    val all: String = ""
)