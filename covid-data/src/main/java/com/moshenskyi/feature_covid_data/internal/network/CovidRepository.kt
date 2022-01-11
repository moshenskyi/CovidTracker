package com.moshenskyi.feature_covid_data.internal.network

import com.moshenskyi.feature_covid_data.internal.model.general.CountryRecordsItem
import com.moshenskyi.feature_covid_data.internal.model.vaccine.VaccineCapacityInfoItem
import kotlinx.coroutines.flow.Flow

internal interface CovidRepository {

	suspend fun getCountriesInfo(): Flow<List<CountryRecordsItem>>

	suspend fun getVaccinationCapacity(): Flow<List<VaccineCapacityInfoItem>>
}
