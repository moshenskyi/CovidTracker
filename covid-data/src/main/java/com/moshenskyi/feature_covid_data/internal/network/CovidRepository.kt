package com.moshenskyi.feature_covid_data.internal.network

import com.moshenskyi.feature_covid_data.internal.model.general.CountryRecordsItem
import com.moshenskyi.feature_covid_data.internal.model.vaccine.VaccineCapacityInfoItem

internal interface CovidRepository {

	suspend fun getCountriesInfo(): List<CountryRecordsItem>

	suspend fun getVaccinationCapacity(): List<VaccineCapacityInfoItem>
}
