package com.moshenskyi.feature_covid_data.internal.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object RetrofitBuilder {
	internal val api: CovidApi

	init {
		val retrofit = Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.client(getClient())
			.build()

		api = retrofit.create(CovidApi::class.java)
	}

	private fun getClient(): OkHttpClient {
		val logging = HttpLoggingInterceptor().apply { setLevel(Level.BODY) }

		return OkHttpClient.Builder()
			.addInterceptor(logging)
			.build()
	}
}
