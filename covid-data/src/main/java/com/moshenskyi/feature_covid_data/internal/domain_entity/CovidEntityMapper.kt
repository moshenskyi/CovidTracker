package com.moshenskyi.feature_covid_data.internal.domain_entity

import com.moshenskyi.feature_covid_data.internal.model.general.CountryRecordsItem
import com.moshenskyi.feature_covid_data.internal.model.vaccine.VaccineCapacityInfoItem

internal fun map(
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
