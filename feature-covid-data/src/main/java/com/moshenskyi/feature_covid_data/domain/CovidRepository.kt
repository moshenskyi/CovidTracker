package com.moshenskyi.feature_covid_data.domain

import kotlinx.coroutines.flow.Flow

interface CovidRepository {

    suspend fun getCountriesInfo(): Flow<List<com.moshenskyi.feature_covid_data.data.model.general.CountryRecordsItem>>

    suspend fun getVaccinationCapacity(): Flow<List<com.moshenskyi.feature_covid_data.data.model.vaccine.VaccineCapacityInfoItem>>

}