package com.moshenskyi.feature_covid_data.data.api

import com.moshenskyi.feature_covid_data.data.model.general.CountryRecordsItem
import com.moshenskyi.feature_covid_data.data.model.vaccine.VaccineCapacityInfoItem
import com.moshenskyi.feature_covid_data.domain.CovidRepository
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
