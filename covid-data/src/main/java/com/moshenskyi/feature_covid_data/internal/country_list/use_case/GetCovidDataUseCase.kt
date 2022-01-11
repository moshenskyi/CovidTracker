package com.moshenskyi.feature_covid_data.internal.country_list.use_case

import com.moshenskyi.feature_covid_data.internal.domain_entity.CovidInfoEntity
import com.moshenskyi.feature_covid_data.internal.domain_entity.map
import com.moshenskyi.feature_covid_data.internal.network.CovidRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.withContext

internal class GetCovidDataUseCase(
	private val repository: CovidRepository,
	private val dispatcher: CoroutineDispatcher
) : UseCase<None, Flow<List<CovidInfoEntity>>> {

	override suspend fun execute(params: None): Flow<List<CovidInfoEntity>> =
		withContext(dispatcher) {
			val countryInfo =
				withContext(Dispatchers.Default) { repository.getCountriesInfo() }
			val vaccinationInfo =
				withContext(Dispatchers.Default) { repository.getVaccinationCapacity() }

			return@withContext countryInfo.combine(vaccinationInfo) { country, vaccine ->
				map(country, vaccine)
			}
		}
}
