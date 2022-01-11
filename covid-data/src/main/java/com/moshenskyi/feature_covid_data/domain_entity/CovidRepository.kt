package com.moshenskyi.feature_covid_data.domain_entity

import com.moshenskyi.feature_covid_data.model.general.CountryRecordsItem
import com.moshenskyi.feature_covid_data.model.vaccine.VaccineCapacityInfoItem
import kotlinx.coroutines.flow.Flow

interface CovidRepository {

	suspend fun getCountriesInfo(): Flow<List<CountryRecordsItem>>

	suspend fun getVaccinationCapacity(): Flow<List<VaccineCapacityInfoItem>>
}
