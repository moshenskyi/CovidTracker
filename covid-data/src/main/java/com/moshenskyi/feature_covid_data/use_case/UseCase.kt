package com.moshenskyi.feature_covid_data.use_case

import androidx.annotation.WorkerThread

internal interface UseCase<in Params, out Result> where Result : Any {

	@WorkerThread
	suspend fun execute(params: Params): Result
}

internal interface Parameter

internal class None : Parameter
