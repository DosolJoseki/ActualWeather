package com.home.joseki.actualweather.data.filesource

import android.content.res.AssetManager
import com.google.gson.Gson
import com.home.joseki.actualweather.model.CityList
import java.io.BufferedReader
import java.io.InputStreamReader

class CitySource(
    private val assetManager: AssetManager
): ICitySource {
    override fun getCities(): CityList {
        BufferedReader(InputStreamReader(assetManager.open("cities.txt"))).use {
            return Gson().fromJson(it, CityList::class.java)
        }
    }
}