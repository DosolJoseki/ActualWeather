package com.home.joseki.actualweather.interactors

import com.home.joseki.actualweather.model.CityInfo
import com.home.joseki.actualweather.model.Weather
import io.reactivex.Observable

interface IWeatherInteractor {
    fun getWeather(cityInfo: CityInfo): Observable<Weather>
}