package com.moshenskyi.feature_covid_data.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moshenskyi.feature_covid_data.data.api.CovidRepositoryImpl
import com.moshenskyi.feature_covid_data.domain.model.CovidInfoEntity
import com.moshenskyi.feature_covid_data.domain.use_case.GetCovidDataUseCase
import com.moshenskyi.feature_covid_data.domain.use_case.None
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CovidViewModel: ViewModel() {
    private val repository = CovidRepositoryImpl()
    private val useCase = GetCovidDataUseCase(repository, Dispatchers.IO)

    private val _info = MutableLiveData<List<CovidInfoEntity>>()
    val infoLiveData: LiveData<List<CovidInfoEntity>> = _info

    fun getCountriesInfo() = viewModelScope.launch {
        useCase.execute(None()).collect {
            _info.value = it
        }

    }

}