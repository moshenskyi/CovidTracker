package com.moshenskyi.feature_covid_data.domain_entity

fun map(
	countryInfo: List<com.moshenskyi.feature_covid_data.model.general.CountryRecordsItem>,
	vaccineCapacityInfo: List<com.moshenskyi.feature_covid_data.model.vaccine.VaccineCapacityInfoItem>
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
