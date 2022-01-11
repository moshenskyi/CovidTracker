package com.moshenskyi.feature_covid_data.model.vaccine

data class VaccineCapacityInfoItem(
    val country: String,
    val timeline: Map<String, Long>
)
