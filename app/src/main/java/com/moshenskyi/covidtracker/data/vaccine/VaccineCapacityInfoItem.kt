package com.moshenskyi.covidtracker.data.vaccine

data class VaccineCapacityInfoItem(
    val country: String,
    val timeline: Map<String, Int>
)