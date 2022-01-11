package com.moshenskyi.feature_covid_data.domain_entity

import com.moshenskyi.feature_covid_data.model.general.CountryRecordsItem
import com.moshenskyi.feature_covid_data.model.vaccine.VaccineCapacityInfoItem

fun map(
	countryInfo: List<CountryRecordsItem>,
	vaccineCapacityInfo: List<VaccineCapacityInfoItem>,
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
