package com.moshenskyi.covidtracker.domain

import com.moshenskyi.covidtracker.data.CountryRecordsItem
import com.moshenskyi.covidtracker.data.vaccine.VaccineCapacityInfoItem
import kotlinx.coroutines.flow.Flow

interface CovidRepository {

    suspend fun getCountriesInfo(): Flow<List<CountryRecordsItem>>

    suspend fun getVaccinationCapacity(): Flow<List<VaccineCapacityInfoItem>>

}