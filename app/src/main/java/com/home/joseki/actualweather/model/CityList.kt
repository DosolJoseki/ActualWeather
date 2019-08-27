package com.home.joseki.actualweather.model

import java.util.ArrayList

data class CityList(
    var Cities: List<CityInfo>? = null
) {
    fun getCityNamesList():List<String>{
        val infoList = ArrayList<String>()
        for (info in Cities!!) {
            infoList.add(info.city + ", " + info.country)
        }

        return infoList
    }
}