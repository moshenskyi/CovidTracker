package com.moshenskyi.covidtracker.data.api

import com.moshenskyi.covidtracker.data.CountryRecordsItem
import com.moshenskyi.covidtracker.data.vaccine.VaccineCapacityInfoItem
import retrofit2.http.GET

const val BASE_URL = "https://disease.sh/"

interface CovidApi {

    @GET("v3/covid-19/countries")
    suspend fun getCountriesInfo(): List<CountryRecordsItem>

    @GET("v3/covid-19/vaccine/coverage/countries?lastdays=30&fullData=false")
    suspend fun getVaccinationCapacity(): List<VaccineCapacityInfoItem>

}