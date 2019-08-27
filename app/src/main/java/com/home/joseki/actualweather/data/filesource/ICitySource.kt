package com.home.joseki.actualweather.data.filesource

import com.home.joseki.actualweather.model.CityList

interface ICitySource {
    fun getCities(): CityList
}