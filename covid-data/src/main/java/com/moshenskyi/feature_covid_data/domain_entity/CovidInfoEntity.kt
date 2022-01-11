package com.moshenskyi.feature_covid_data.domain_entity

import com.moshenskyi.feature_covid_data.model.vaccine.VaccineCapacityInfoItem

data class CovidInfoEntity(
    val testCount: Int,
    val country: String,
    val population: Int,
    val vaccineCapacityInfoItem: VaccineCapacityInfoItem?,
    var expanded: Boolean
)
