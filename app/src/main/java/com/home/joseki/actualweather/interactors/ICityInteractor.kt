package com.home.joseki.actualweather.interactors

import com.home.joseki.actualweather.model.CityList

interface ICityInteractor {
    fun getCities(): CityList
}