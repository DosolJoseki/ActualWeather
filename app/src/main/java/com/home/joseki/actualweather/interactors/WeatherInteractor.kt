package com.home.joseki.actualweather.interactors

import com.home.joseki.actualweather.model.City
import com.home.joseki.actualweather.model.CityList
import com.home.joseki.actualweather.model.Weather
import com.home.joseki.actualweather.repositories.IWeatherRepository
import com.home.joseki.actualweather.repositories.WeatherRepository
import io.reactivex.Observable

class WeatherInteractor(private val weatherRepository: IWeatherRepository) : IWeatherInteractor {
    override fun getWeather(cityInfo: CityList.CityInfo): Observable<Weather> =
        weatherRepository.getWeather(cityInfo)
}