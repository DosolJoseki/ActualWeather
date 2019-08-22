package com.home.joseki.actualweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.home.joseki.actualweather.di.Scopes
import com.home.joseki.actualweather.interactors.IWeatherInteractor
import com.home.joseki.actualweather.model.City
import com.home.joseki.actualweather.model.Coord
import kotlinx.android.synthetic.main.activity_main.*
import toothpick.Toothpick

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: MainActivityPresenter
    private var city: City = City()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateProgress.setOnRefreshListener { presenter.getWeatherInfo(city) }
    }

    fun showUpdateProgress(show: Boolean){
        updateProgress.isRefreshing = show
    }

    override fun onStart() {
        super.onStart()
        val scope = Toothpick.openScope(Scopes.APP)
        Toothpick.inject(this, scope)
        presenter = MainActivityPresenter(this, scope.getInstance(IWeatherInteractor::class.java))
    }
}
