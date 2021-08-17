package com.moshenskyi.feature_covid_data.domain.use_case

import androidx.annotation.WorkerThread

interface UseCase<in Params, out Result> where Result : Any {

    @WorkerThread
    suspend fun execute(params: Params): Result

}

interface Parameter

class None: Parameter