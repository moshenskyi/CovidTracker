package com.moshenskyi.feature_covid_data.internal.network

import com.moshenskyi.core.ConnectionError
import com.moshenskyi.core.ServerError
import com.moshenskyi.feature_covid_data.internal.model.general.CountryRecordsItem
import com.moshenskyi.feature_covid_data.internal.model.vaccine.VaccineCapacityInfoItem
import java.io.IOException

internal class CovidRepositoryImpl : CovidRepository {
	private val api = RetrofitBuilder.api

	override suspend fun getCountriesInfo(): List<CountryRecordsItem> {
		return runCatching {
			api.getCountriesInfo()
		}.onFailure { error ->
			when (error) {
				is IOException -> throw ConnectionError(cause = error)
				else -> throw ServerError(cause = error)
			}
		}.getOrThrow()
	}

	override suspend fun getVaccinationCapacity(): List<VaccineCapacityInfoItem> {
		return api.getVaccinationCapacity()
	}
}
