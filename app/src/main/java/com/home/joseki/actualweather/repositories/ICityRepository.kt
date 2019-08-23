package com.home.joseki.actualweather.repositories

import android.app.Activity
import com.home.joseki.actualweather.model.CityList

interface ICityRepository {
    fun getCities(activity: Activity): CityList
}