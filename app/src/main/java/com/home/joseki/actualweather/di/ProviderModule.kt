package com.home.joseki.actualweather.di

import com.home.joseki.actualweather.di.providers.WeatherInteractorProvider
import com.home.joseki.actualweather.interactors.IWeatherInteractor
import toothpick.config.Module

class ProviderModule: Module() {
    init {
        bind(IWeatherInteractor::class.java).toProvider(WeatherInteractorProvider::class.java).providesSingletonInScope()
    }
}