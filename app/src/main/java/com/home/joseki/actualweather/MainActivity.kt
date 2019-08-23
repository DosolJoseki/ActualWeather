package com.home.joseki.actualweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.home.joseki.actualweather.adapters.CityAdapter
import com.home.joseki.actualweather.adapters.WeatherAdapter
import com.home.joseki.actualweather.di.Scopes
import com.home.joseki.actualweather.interactors.ICityInteractor
import com.home.joseki.actualweather.interactors.IWeatherInteractor
import com.home.joseki.actualweather.model.City
import com.home.joseki.actualweather.model.CityList
import com.home.joseki.actualweather.model.Coord
import com.home.joseki.actualweather.model.Weather
import com.squareup.picasso.Picasso
import com.toptoche.searchablespinnerlibrary.SearchableSpinner
import kotlinx.android.synthetic.main.activity_main.*
import toothpick.Toothpick
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: MainActivityPresenter
    private lateinit var citySpinner: SearchableSpinner
    private lateinit var weatherAdapter: WeatherAdapter

    private val BUTTON_SELECT = "Select Item"
    private val BUTTON_BACK = "Back"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showUpdateProgress(show: Boolean){
        updateProgress.isRefreshing = show
    }

    override fun onStart() {
        super.onStart()
        val scope = Toothpick.openScope(Scopes.APP)
        Toothpick.inject(this, scope)
        presenter = MainActivityPresenter(this, scope.getInstance(IWeatherInteractor::class.java), scope.getInstance(ICityInteractor::class.java))
        weatherAdapter = WeatherAdapter(this)
        recyclerDay.adapter = weatherAdapter
        citySpinnerPreparation()
    }

    fun citySpinnerPreparation() {
        citySpinner = this.findViewById(R.id.city_spinner)
        citySpinner.setTitle(BUTTON_SELECT)
        citySpinner.setPositiveButton(BUTTON_BACK)

        citySpinner.adapter = CityAdapter(this, R.id.city_spinner, presenter.getCities().getCityNamesList())
        citySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val info = presenter.getCities().Cities!![position]
                presenter.getWeatherInfo(info)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    fun updateWeatherInfo(weather: Weather) {
        tvTemp.text = String.format(getString(R.string.temp_info), weather.list!![0].main!!.temp)

        weatherAdapter.clearItems()
        weatherAdapter.setItems(weather.list)
    }

    fun updateWeatherIcon(icon: String){
        Picasso.get().load(String.format(getString(R.string.icon_url), icon)).into(ivWeatherIcon)
    }
}
