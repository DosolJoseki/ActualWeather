package com.home.joseki.actualweather.interactors

import com.home.joseki.actualweather.model.CityInfo
import com.home.joseki.actualweather.model.Weather
import com.home.joseki.actualweather.repositories.IWeatherRepository
import io.reactivex.Observable

class WeatherInteractor(
    private val weatherRepository: IWeatherRepository
) : IWeatherInteractor {
    override fun getWeather(cityInfo: CityInfo): Observable<Weather> =
        weatherRepository.getWeather(cityInfo)
}