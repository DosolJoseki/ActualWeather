package com.home.joseki.actualweather.comparators

class CityNameComparator: Comparator<String> {
    override fun compare(o1: String, o2: String): Int {
        return o1.compareTo(o2)

    }
}