package com.home.joseki.actualweather.repositories

import com.home.joseki.actualweather.model.CityInfo
import com.home.joseki.actualweather.model.Weather
import io.reactivex.Observable

interface IWeatherRepository {
    fun getWeather(cityInfo: CityInfo): Observable<Weather>
}