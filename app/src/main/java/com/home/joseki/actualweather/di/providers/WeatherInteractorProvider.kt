package com.home.joseki.actualweather.di.providers

import com.home.joseki.actualweather.interactors.WeatherInteractor
import com.home.joseki.actualweather.repositories.WeatherRepository
import javax.inject.Inject
import javax.inject.Provider


class WeatherInteractorProvider @Inject constructor(
        private val weatherRepository: WeatherRepository
): Provider<WeatherInteractor> {
    override fun get(): WeatherInteractor = WeatherInteractor(weatherRepository)
}