package com.moshenskyi.feature_covid_data.internal.country_list.use_case

import com.moshenskyi.feature_covid_data.internal.domain_entity.CovidInfoEntity
import com.moshenskyi.feature_covid_data.internal.domain_entity.map
import com.moshenskyi.feature_covid_data.internal.network.CovidRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

internal class GetCovidDataUseCase(
	private val repository: CovidRepository,
	private val dispatcher: CoroutineDispatcher,
) : UseCase<NoParams, List<CovidInfoEntity>> {

	override suspend fun execute(params: NoParams): List<CovidInfoEntity> {
		return withContext(dispatcher) {
			val countryInfo =
				async { repository.getCountriesInfo() }
			val vaccinationInfo =
				async { repository.getVaccinationCapacity() }

			return@withContext map(countryInfo.await(), vaccinationInfo.await())
		}
	}
}
