package com.home.joseki.actualweather.repositories

import android.app.Activity
import com.google.gson.Gson
import com.home.joseki.actualweather.model.CityList
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class CityRepository(): ICityRepository {
    override fun getCities(activity: Activity): CityList {
        try {
            val reader = BufferedReader(
                InputStreamReader(activity.assets.open("cities.txt"))
            )
            val gson = Gson()
            return gson.fromJson(reader, CityList::class.java)
        } catch (e: IOException) {
            return CityList()
        }
    }
}