package com.home.joseki.actualweather

import com.home.joseki.actualweather.interactors.ICityInteractor
import com.home.joseki.actualweather.interactors.IWeatherInteractor
import com.home.joseki.actualweather.model.CityList
import com.home.joseki.actualweather.model.Weather
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.lang.StringBuilder
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(
    private val view: MainActivity,
    private val weatherInteractor: IWeatherInteractor,
    private val cityInteractor: ICityInteractor
) {
    private var cityList: CityList = CityList()

    private val compositeDisposable = CompositeDisposable()

    fun getWeatherInfo(cityInfo: CityList.CityInfo){
        weatherInteractor.getWeather(cityInfo)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view.showUpdateProgress(false)
                weatherProcessing(it)
            }
    }

    fun weatherProcessing(weather: Weather){
        view.updateWeatherIcon(weather.list!![0].weather!![0].icon!!)
        view.updateWeatherInfo(weather)
        view.showUpdateProgress(false)
    }

    fun getCities(): CityList = cityInteractor.getCities(view)

    fun onGetWeatherInfo() {

    }

    fun onCitySelectClick() {

    }

    fun onCitySelected() {

    }

    fun onDestroy() {
        compositeDisposable.clear()
    }
}