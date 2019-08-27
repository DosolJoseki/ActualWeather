package com.home.joseki.actualweather.repositories

import com.home.joseki.actualweather.model.CityList

interface ICityRepository {
    fun getCities(): CityList
}