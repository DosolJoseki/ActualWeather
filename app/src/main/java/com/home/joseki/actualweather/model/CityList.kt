package com.home.joseki.actualweather.model

import java.util.ArrayList

data class CityList(
    var Cities: List<CityInfo>? = null
) {
    fun getCityNamesList():List<String>{
        val infosList = ArrayList<String>()
        for (info in Cities!!) {
            infosList.add(info.city + ", " + info.country)
        }

        return infosList
    }
}