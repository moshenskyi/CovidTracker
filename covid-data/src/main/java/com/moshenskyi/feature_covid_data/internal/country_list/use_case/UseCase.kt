package com.moshenskyi.feature_covid_data.internal.country_list.use_case

import androidx.annotation.WorkerThread

internal interface UseCase<in Params, out Result> where Result : Any {

	@WorkerThread
	suspend fun execute(params: Params): Result
}

internal interface Parameter

internal class NoParams : Parameter
