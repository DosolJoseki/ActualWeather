package com.home.joseki.actualweather.di

import com.home.joseki.actualweather.di.providers.CityInteractorProvider
import com.home.joseki.actualweather.di.providers.WeatherInteractorProvider
import com.home.joseki.actualweather.interactors.ICityInteractor
import com.home.joseki.actualweather.interactors.IWeatherInteractor
import com.home.joseki.actualweather.interactors.WeatherInteractor
import toothpick.config.Module

class ProviderModule: Module() {
    init {
        bind(IWeatherInteractor::class.java).toProvider(WeatherInteractorProvider::class.java).providesSingletonInScope()
        bind(ICityInteractor::class.java).toProvider(CityInteractorProvider::class.java).providesSingletonInScope()
    }
}