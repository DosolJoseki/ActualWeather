package com.home.joseki.actualweather

import android.content.SharedPreferences
import com.home.joseki.actualweather.interactors.ICityInteractor
import com.home.joseki.actualweather.interactors.IWeatherInteractor
import com.home.joseki.actualweather.model.CityInfo
import com.home.joseki.actualweather.model.CityList
import com.home.joseki.actualweather.model.Weather
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(
    private val view: MainActivity,
    private val weatherInteractor: IWeatherInteractor,
    private val cityInteractor: ICityInteractor
) {

    companion object {
        private const val STORAGE_NAME = "SelectedCity"
    }

    private lateinit var city: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private val compositeDisposable = CompositeDisposable()

    fun getWeatherInfo(cityInfo: CityInfo){
        city = view.getSharedPreferences(STORAGE_NAME, 0)
        editor = city.edit()
        editor.putString(STORAGE_NAME, cityInfo.city)
        editor.apply()
        view.updateCityAdapter(cityInfo.city + ", " + cityInfo.country)

        weatherInteractor.getWeather(cityInfo)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view.showUpdateProgress(false)
                weatherProcessing(it)
            }
    }

    private fun weatherProcessing(weather: Weather){
        view.updateWeatherIcon(weather.list!![0].weather!![0].icon)
        view.updateWeatherInfo(weather)
        view.showUpdateProgress(false)
    }

    fun getCities(): CityList = cityInteractor.getCities(view)

    fun onDestroy(){
        compositeDisposable.clear()
    }
}