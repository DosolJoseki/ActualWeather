package com.home.joseki.actualweather.di

import com.home.joseki.actualweather.di.providers.WeatherRepositoryProvider
import com.home.joseki.actualweather.repositories.IWeatherRepository
import toothpick.config.Module

class RepositoryModule: Module() {
    init {
        bind(IWeatherRepository::class.java).toProvider(WeatherRepositoryProvider::class.java).providesSingletonInScope()
    }
}