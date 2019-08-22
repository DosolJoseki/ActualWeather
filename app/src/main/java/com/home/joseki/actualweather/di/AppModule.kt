package com.home.joseki.actualweather.di

import android.content.Context
import com.home.joseki.actualweather.App
import toothpick.config.Module

class AppModule(app: App) : Module() {
    init {
        bind(Context::class.java).toInstance(app)
    }
}