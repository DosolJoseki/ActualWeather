package com.home.joseki.actualweather.repositories

import com.home.joseki.actualweather.model.City
import com.home.joseki.actualweather.model.CityList
import com.home.joseki.actualweather.model.Weather
import com.home.joseki.actualweather.web.api.IOpenWeatherMapAPI
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class WeatherRepository(
        private val openWeatherMapAPI: IOpenWeatherMapAPI
        ):IWeatherRepository {

    private val UNITS_TYPE_METRIC = "metric"
    private val OPEN_WEATHER_API_KEY = "44534c0b4792d659833832a3af0b6f34"

    override fun getWeather(cityInfo: CityList.CityInfo): Observable<Weather> =
        openWeatherMapAPI.getWeatherByCity(cityInfo.lat!!, cityInfo.lng!!, UNITS_TYPE_METRIC, OPEN_WEATHER_API_KEY)
            //.doOnNext()
            .subscribeOn(Schedulers.io())
}