package com.home.joseki.actualweather.di.api

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.home.joseki.actualweather.web.api.OpenWeatherAPIProvider
import com.home.joseki.actualweather.web.api.OpenWeatherMapAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import toothpick.config.Module

class ApiModule: Module() {
    init {
        bind(OkHttpClient::class.java).toInstance(
            OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
                .build())
        bind(OpenWeatherMapAPI::class.java).toProvider(OpenWeatherAPIProvider::class.java).providesSingletonInScope()
    }
}