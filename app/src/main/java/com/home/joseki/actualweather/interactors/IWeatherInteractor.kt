package com.home.joseki.actualweather.interactors

import com.home.joseki.actualweather.model.City
import com.home.joseki.actualweather.model.Weather
import io.reactivex.Observable

interface IWeatherInteractor {
    fun getWeather(city: City): Observable<Weather>
}