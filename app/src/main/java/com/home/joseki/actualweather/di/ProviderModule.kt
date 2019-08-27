package com.home.joseki.actualweather.di

import com.home.joseki.actualweather.data.filesource.ICitySource
import com.home.joseki.actualweather.di.providers.CityInteractorProvider
import com.home.joseki.actualweather.di.providers.CitySourceProvider
import com.home.joseki.actualweather.di.providers.WeatherInteractorProvider
import com.home.joseki.actualweather.interactors.ICityInteractor
import com.home.joseki.actualweather.interactors.IWeatherInteractor
import toothpick.config.Module

class ProviderModule: Module() {
    init {
        bind(IWeatherInteractor::class.java).toProvider(WeatherInteractorProvider::class.java).providesSingletonInScope()
        bind(ICityInteractor::class.java).toProvider(CityInteractorProvider::class.java).providesSingletonInScope()
        bind(ICitySource::class.java).toProvider(CitySourceProvider::class.java).providesSingletonInScope()
    }
}