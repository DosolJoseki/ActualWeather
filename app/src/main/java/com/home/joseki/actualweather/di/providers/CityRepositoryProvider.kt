package com.home.joseki.actualweather.di.providers

import com.home.joseki.actualweather.repositories.CityRepository
import com.home.joseki.actualweather.repositories.ICityRepository
import javax.inject.Inject
import javax.inject.Provider

class CityRepositoryProvider @Inject constructor(): Provider<ICityRepository> {
    override fun get(): ICityRepository = CityRepository()

}