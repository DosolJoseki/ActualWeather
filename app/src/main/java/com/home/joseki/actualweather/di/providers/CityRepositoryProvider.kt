package com.home.joseki.actualweather.di.providers

import com.home.joseki.actualweather.data.filesource.ICitySource
import com.home.joseki.actualweather.repositories.CityRepository
import com.home.joseki.actualweather.repositories.ICityRepository
import javax.inject.Inject
import javax.inject.Provider

class CityRepositoryProvider @Inject constructor(
    private val citySource: ICitySource
): Provider<ICityRepository> {
    override fun get(): ICityRepository = CityRepository(citySource)
}