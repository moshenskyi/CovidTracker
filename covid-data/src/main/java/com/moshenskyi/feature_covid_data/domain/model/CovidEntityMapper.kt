package com.moshenskyi.feature_covid_data.domain.model

fun map(
	countryInfo: List<com.moshenskyi.feature_covid_data.data.model.general.CountryRecordsItem>,
	vaccineCapacityInfo: List<com.moshenskyi.feature_covid_data.data.model.vaccine.VaccineCapacityInfoItem>,
): List<CovidInfoEntity> {
	val infoList = mutableListOf<CovidInfoEntity>()

	countryInfo.forEach { item ->
		val element = vaccineCapacityInfo.find { item.country == it.country }

		infoList.add(
			CovidInfoEntity(
				item.tests,
				item.country,
				item.population,
				element,
				false
			)
		)
	}

	return infoList
}
