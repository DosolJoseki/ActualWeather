package com.home.joseki.actualweather.web.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Inject
import javax.inject.Provider

class OpenWeatherAPIProvider @Inject constructor(private val okHttpClient: OkHttpClient) : Provider<OpenWeatherMapAPI> {
    private val baseUrl: String = "http://api.openweathermap.org/data/2.5/"

    override fun get(): OpenWeatherMapAPI = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(OpenWeatherMapAPI::class.java)
}