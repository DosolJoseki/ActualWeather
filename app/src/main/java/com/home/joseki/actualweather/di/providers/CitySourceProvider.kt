package com.home.joseki.actualweather.di.providers

import android.content.res.AssetManager
import com.home.joseki.actualweather.data.filesource.CitySource
import com.home.joseki.actualweather.data.filesource.ICitySource
import javax.inject.Inject
import javax.inject.Provider

class CitySourceProvider @Inject constructor(
    private val assetManager: AssetManager
): Provider<ICitySource> {
    override fun get(): ICitySource = CitySource(assetManager)
}