package com.home.joseki.actualweather.interactors

import android.app.Activity
import com.home.joseki.actualweather.model.CityList

interface ICityInteractor {
    fun getCities(activity: Activity): CityList
}