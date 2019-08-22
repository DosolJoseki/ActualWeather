package com.home.joseki.actualweather

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.home.joseki.actualweather.di.AppModule
import com.home.joseki.actualweather.di.ProviderModule
import com.home.joseki.actualweather.di.RepositoryModule
import com.home.joseki.actualweather.di.Scopes
import com.home.joseki.actualweather.di.api.ApiModule
import timber.log.Timber
import toothpick.Scope
import toothpick.Toothpick
import toothpick.configuration.Configuration

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Toothpick.setConfiguration(Configuration.forDevelopment())
        }
        val appScope: Scope = Toothpick.openScope(Scopes.APP)
        appScope.installModules(AppModule(this), ApiModule(), ProviderModule(), RepositoryModule())

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}