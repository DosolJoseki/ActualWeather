package com.home.joseki.actualweather.model

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("coord")
    val coord: Coord = Coord(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("country")
    val country: String = ""
 )