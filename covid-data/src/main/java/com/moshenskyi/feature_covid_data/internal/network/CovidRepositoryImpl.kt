package com.moshenskyi.feature_covid_data.internal.network

import com.moshenskyi.feature_covid_data.internal.model.general.CountryRecordsItem
import com.moshenskyi.feature_covid_data.internal.model.vaccine.VaccineCapacityInfoItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class CovidRepositoryImpl : CovidRepository {
	private val api = RetrofitBuilder.api

	override suspend fun getCountriesInfo(): Flow<List<CountryRecordsItem>> {
		return flowOf(api.getCountriesInfo())
	}

	override suspend fun getVaccinationCapacity(): Flow<List<VaccineCapacityInfoItem>> {
		return flowOf(api.getVaccinationCapacity())
	}
}
