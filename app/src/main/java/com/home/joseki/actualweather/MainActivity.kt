package com.home.joseki.actualweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import com.home.joseki.actualweather.adapters.CityAdapter
import com.home.joseki.actualweather.adapters.WeatherAdapter
import com.home.joseki.actualweather.comparators.CityComparator
import com.home.joseki.actualweather.comparators.CityComparatorByClass
import com.home.joseki.actualweather.di.Scopes
import com.home.joseki.actualweather.interactors.ICityInteractor
import com.home.joseki.actualweather.interactors.IWeatherInteractor
import com.home.joseki.actualweather.model.CityList
import com.home.joseki.actualweather.model.Weather
import com.squareup.picasso.Picasso
import com.toptoche.searchablespinnerlibrary.SearchableSpinner
import kotlinx.android.synthetic.main.activity_main.*
import toothpick.Toothpick
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var presenter: MainActivityPresenter
    private lateinit var citySpinner: SearchableSpinner
    private lateinit var weatherAdapter: WeatherAdapter
    private lateinit var cityAdapter: CityAdapter
    private lateinit var cityInfo: CityList.CityInfo
    private lateinit var cities: List<String>
    private lateinit var citiesClass: List<CityList.CityInfo>

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
        recyclerDay.layoutManager = LinearLayoutManager(this)
        updateProgress.setOnRefreshListener { presenter.getWeatherInfo(cityInfo) }
        citySpinnerPreparation()
    }

    fun citySpinnerPreparation() {
        citySpinner = this.findViewById(R.id.city_spinner)
        citySpinner.setPositiveButton(BUTTON_BACK)

        cities = presenter.getCities().getCityNamesList()
        citiesClass = presenter.getCities().Cities!!
        Collections.sort(cities, CityComparator())
        Collections.sort(citiesClass, CityComparatorByClass())
        cityAdapter = CityAdapter(this, R.id.city_spinner, cities)
        citySpinner.adapter = cityAdapter
        citySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val info = citiesClass[position]
                cityInfo = info
                citySpinner.setTitle(cityInfo.city)
                presenter.getWeatherInfo(cityInfo)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    fun updateCityAdapter(compareValue: String){
        val spinnerPosition = cityAdapter.getPosition(compareValue)
        citySpinner.setSelection(spinnerPosition)
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
