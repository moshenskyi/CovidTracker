package com.moshenskyi.covidtracker.domain.model

import com.moshenskyi.covidtracker.data.CountryRecordsItem
import com.moshenskyi.covidtracker.data.vaccine.VaccineCapacityInfoItem

fun map(
    countryInfo: List<CountryRecordsItem>,
    vaccineCapacityInfo: List<VaccineCapacityInfoItem>
): List<CovidInfoEntity> {
    val infoList = mutableListOf<CovidInfoEntity>()

    countryInfo.forEach { item ->
        val element = vaccineCapacityInfo.find { item.country == it.country }

        infoList.add(
            CovidInfoEntity(
                item.tests,
                item.country,
                item.population,
                element
            )
        )
    }

    return infoList
}