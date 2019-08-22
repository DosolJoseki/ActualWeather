package com.home.joseki.actualweather.di.providers

import com.home.joseki.actualweather.interactors.IWeatherInteractor
import com.home.joseki.actualweather.interactors.WeatherInteractor
import com.home.joseki.actualweather.repositories.IWeatherRepository
import com.home.joseki.actualweather.repositories.WeatherRepository
import javax.inject.Inject
import javax.inject.Provider


class WeatherInteractorProvider @Inject constructor(
        private val weatherRepository: IWeatherRepository
): Provider<IWeatherInteractor> {
    override fun get(): IWeatherInteractor = WeatherInteractor(weatherRepository)
}