package com.moshenskyi.feature_covid_data.domain.model

data class CovidInfoEntity(
    val testCount: Int,
    val country: String,
    val population: Int,
    val vaccineCapacityInfoItem: com.moshenskyi.feature_covid_data.data.model.vaccine.VaccineCapacityInfoItem?
)