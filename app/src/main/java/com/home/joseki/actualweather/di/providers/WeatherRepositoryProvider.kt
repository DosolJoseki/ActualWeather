package com.home.joseki.actualweather.di.providers

import com.home.joseki.actualweather.repositories.IWeatherRepository
import com.home.joseki.actualweather.repositories.WeatherRepository
import com.home.joseki.actualweather.web.api.OpenWeatherMapAPI
import javax.inject.Inject
import javax.inject.Provider

class WeatherRepositoryProvider @Inject constructor(
        private val openWeatherMapAPI: OpenWeatherMapAPI
): Provider<IWeatherRepository> {
    override fun get(): IWeatherRepository = WeatherRepository(openWeatherMapAPI)
}