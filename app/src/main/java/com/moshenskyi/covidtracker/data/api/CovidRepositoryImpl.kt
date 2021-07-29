package com.moshenskyi.covidtracker.data.api

import com.moshenskyi.covidtracker.data.CountryRecordsItem
import com.moshenskyi.covidtracker.data.vaccine.VaccineCapacityInfoItem
import com.moshenskyi.covidtracker.domain.CovidRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CovidRepositoryImpl : CovidRepository {
    private val api = RetrofitBuilder.api

    override suspend fun getCountriesInfo(): Flow<List<CountryRecordsItem>> {
        return flowOf(api.getCountriesInfo())
    }

    override suspend fun getVaccinationCapacity(): Flow<List<VaccineCapacityInfoItem>> {
        return flowOf(api.getVaccinationCapacity())
    }

}