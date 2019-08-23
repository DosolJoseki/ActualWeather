package com.home.joseki.actualweather.interactors

import android.app.Activity
import com.home.joseki.actualweather.model.CityList
import com.home.joseki.actualweather.repositories.ICityRepository

class CityInteractor(private val cityRepository: ICityRepository): ICityInteractor {
    override fun getCities(activity: Activity): CityList =
        cityRepository.getCities(activity)
}