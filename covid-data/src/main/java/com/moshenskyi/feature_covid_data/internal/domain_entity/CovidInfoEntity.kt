package com.moshenskyi.feature_covid_data.internal.domain_entity

import com.moshenskyi.feature_covid_data.internal.model.vaccine.VaccineCapacityInfoItem

internal data class CovidInfoEntity(
    val testCount: Int,
    val country: String,
    val population: Int,
    val vaccineCapacityInfoItem: VaccineCapacityInfoItem?,
    var expanded: Boolean
)
