package com.moshenskyi.feature_covid_data.internal.model.vaccine

internal data class VaccineCapacityInfoItem(
    val country: String,
    val timeline: Map<String, Long>
)
