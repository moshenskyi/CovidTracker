package com.moshenskyi.covidtracker.domain.model

import com.moshenskyi.covidtracker.data.vaccine.VaccineCapacityInfoItem

data class CovidInfoEntity(
    val testCount: Int,
    val country: String,
    val population: Int,
    val vaccineCapacityInfoItem: VaccineCapacityInfoItem?
)