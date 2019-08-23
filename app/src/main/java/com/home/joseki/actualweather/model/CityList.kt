package com.home.joseki.actualweather.model

import java.util.ArrayList

class CityList {
    val Cities: List<CityInfo>? = null

    inner class CityInfo {
        val city: String? = null
        val city_ascii: String? = null
        val lat: String? = null
        val lng: String? = null
        val country: String? = null
        val iso2: String? = null
        val iso3: String? = null
        val admin_name: String? = null
        val capital: String? = null
        val id: String? = null
    }

    fun getCityNamesList():List<String>{
        val infosList = ArrayList<String>()
        for (info in Cities!!) {
            infosList.add(info.city + ", " + info.country)
        }

        return infosList
    }
}