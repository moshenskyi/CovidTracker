package com.moshenskyi.feature_covid_data.network

import com.moshenskyi.feature_covid_data.model.general.CountryRecordsItem
import com.moshenskyi.feature_covid_data.model.vaccine.VaccineCapacityInfoItem
import retrofit2.http.GET

const val BASE_URL = "https://disease.sh/"

internal interface CovidApi {

	@GET("v3/covid-19/countries")
	suspend fun getCountriesInfo(): List<CountryRecordsItem>

	@GET("v3/covid-19/vaccine/coverage/countries?lastdays=30&fullData=false")
	suspend fun getVaccinationCapacity(): List<VaccineCapacityInfoItem>
}
