package com.home.joseki.actualweather.web.api

import com.home.joseki.actualweather.model.Weather
import io.reactivex.Observable
import retrofit2.http.*

interface OpenWeatherMapAPI {
    @GET("forecast")
    fun getWeatherByCity(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("units") units: String,
        @Query("appid") appid: String
    ): Observable<Weather>
}