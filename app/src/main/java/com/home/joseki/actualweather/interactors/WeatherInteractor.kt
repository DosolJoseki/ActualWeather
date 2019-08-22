package com.home.joseki.actualweather.interactors

import com.home.joseki.actualweather.model.City
import com.home.joseki.actualweather.model.Weather
import com.home.joseki.actualweather.repositories.WeatherRepository
import io.reactivex.Observable

class WeatherInteractor(private val weatherRepository: WeatherRepository) : IWeatherInteractor {
    override fun getWeather(city: City): Observable<Weather> =
        weatherRepository.getWeather(city)

}