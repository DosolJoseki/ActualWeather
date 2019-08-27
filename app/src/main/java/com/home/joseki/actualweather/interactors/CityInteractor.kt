package com.home.joseki.actualweather.interactors

import android.content.res.AssetManager
import com.home.joseki.actualweather.model.CityList
import com.home.joseki.actualweather.repositories.ICityRepository

class CityInteractor(
    private val cityRepository: ICityRepository
): ICityInteractor {
    override fun getCities(): CityList = cityRepository.getCities()
}