package com.home.joseki.actualweather.comparators

import com.home.joseki.actualweather.model.CityList

class CityComparatorByClass: Comparator<CityList.CityInfo> {
    override fun compare(o1: CityList.CityInfo, o2: CityList.CityInfo): Int {
        return o1.city!!.compareTo(o2.city!!)
    }
}