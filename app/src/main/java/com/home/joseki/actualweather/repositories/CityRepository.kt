package com.home.joseki.actualweather.repositories

import com.home.joseki.actualweather.data.filesource.ICitySource
import com.home.joseki.actualweather.model.CityList

class CityRepository(
   private val citySource: ICitySource
): ICityRepository {
    override fun getCities(): CityList {
        return citySource.getCities()
    }
}