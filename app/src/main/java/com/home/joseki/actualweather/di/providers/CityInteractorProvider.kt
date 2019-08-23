package com.home.joseki.actualweather.di.providers

import com.home.joseki.actualweather.interactors.CityInteractor
import com.home.joseki.actualweather.interactors.ICityInteractor
import com.home.joseki.actualweather.repositories.ICityRepository
import javax.inject.Inject
import javax.inject.Provider

class CityInteractorProvider @Inject constructor(
    private val cityRepository: ICityRepository
): Provider<ICityInteractor> {
    override fun get(): ICityInteractor = CityInteractor(cityRepository)
}