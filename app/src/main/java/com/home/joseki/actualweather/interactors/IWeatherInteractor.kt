package com.home.joseki.actualweather.interactors

import com.home.joseki.actualweather.model.CityList
import com.home.joseki.actualweather.model.Weather
import io.reactivex.Observable

interface IWeatherInteractor {
    fun getWeather(cityInfo: CityList.CityInfo): Observable<Weather>
}