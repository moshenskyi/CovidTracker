package com.moshenskyi.feature_covid_data.domain

import com.moshenskyi.feature_covid_data.data.model.general.CountryRecordsItem
import com.moshenskyi.feature_covid_data.data.model.vaccine.VaccineCapacityInfoItem
import kotlinx.coroutines.flow.Flow

interface CovidRepository {

    suspend fun getCountriesInfo(): Flow<List<CountryRecordsItem>>

    suspend fun getVaccinationCapacity(): Flow<List<VaccineCapacityInfoItem>>
}
