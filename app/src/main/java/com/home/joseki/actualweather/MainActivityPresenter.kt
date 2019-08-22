package com.home.joseki.actualweather

import com.home.joseki.actualweather.interactors.IWeatherInteractor
import com.home.joseki.actualweather.model.City
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(
    private val view: MainActivity,
    private val weatherInteractor: IWeatherInteractor
) {

    private val compositeDisposable = CompositeDisposable()

    fun getWeatherInfo(city: City){
        weatherInteractor.getWeather(city)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { view.showUpdateProgress(false) }
    }

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