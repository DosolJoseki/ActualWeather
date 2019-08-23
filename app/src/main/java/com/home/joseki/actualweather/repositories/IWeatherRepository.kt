package com.home.joseki.actualweather.repositories

import com.home.joseki.actualweather.model.City
import com.home.joseki.actualweather.model.CityList
import com.home.joseki.actualweather.model.Weather
import io.reactivex.Observable

interface IWeatherRepository {
    fun getWeather(cityInfo: CityList.CityInfo): Observable<Weather>
}