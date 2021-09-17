package com.moshenskyi.feature_covid_data.domain.model

import com.moshenskyi.feature_covid_data.data.model.vaccine.VaccineCapacityInfoItem

data class CovidInfoEntity(
    val testCount: Int,
    val country: String,
    val population: Int,
    val vaccineCapacityInfoItem: VaccineCapacityInfoItem?
)
