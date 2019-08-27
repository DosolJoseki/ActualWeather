package com.home.joseki.actualweather.comparators

import com.home.joseki.actualweather.model.CityInfo

class CityComparatorByClass: Comparator<CityInfo> {
    override fun compare(o1: CityInfo, o2: CityInfo): Int {
        return o1.city.compareTo(o2.city)
    }
}