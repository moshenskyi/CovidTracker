package com.moshenskyi.feature_covid_data.internal.model.general

import com.google.gson.annotations.SerializedName

internal data class CountryInfo(
	@SerializedName("_id")
	val id: Int,
	val flag: String,
	val iso2: String,
	val iso3: String,
	val lat: Double,
	val long: Double
)
