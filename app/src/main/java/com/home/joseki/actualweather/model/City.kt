package com.home.joseki.actualweather.model

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("coord")
    private val coord: Coord = Coord(),
    @SerializedName("id")
    private val id: String = "",
    @SerializedName("name")
    private val name: String = "",
    @SerializedName("country")
    private val country: String = ""
 )