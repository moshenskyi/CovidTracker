package com.moshenskyi.feature_covid_data.covid_data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moshenskyi.feature_covid_data.domain_entity.CovidInfoEntity
import com.moshenskyi.feature_covid_data.network.CovidRepositoryImpl
import com.moshenskyi.feature_covid_data.use_case.GetCovidDataUseCase
import com.moshenskyi.feature_covid_data.use_case.None
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CovidViewModel : ViewModel() {
	// TODO: 1/11/22 Inject in constructor
	private val useCase = GetCovidDataUseCase(CovidRepositoryImpl(), Dispatchers.IO)

	private val _info = MutableLiveData<List<CovidInfoEntity>?>()
	val infoLiveData: LiveData<List<CovidInfoEntity>?> = _info

	fun getCountriesInfo() = viewModelScope.launch {
		useCase.execute(None()).collect { data ->
			_info.value = data
		}
	}

	fun onExpanded(position: Int) {
		_info.value?.let { infoList ->
			_info.value = handleExpansion(position, infoList)
		}
	}
}
