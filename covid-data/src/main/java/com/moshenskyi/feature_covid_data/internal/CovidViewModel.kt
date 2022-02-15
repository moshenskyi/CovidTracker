package com.moshenskyi.feature_covid_data.internal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moshenskyi.core.ScreenState
import com.moshenskyi.feature_covid_data.internal.country_list.use_case.GetCovidDataUseCase
import com.moshenskyi.feature_covid_data.internal.country_list.use_case.None
import com.moshenskyi.feature_covid_data.internal.domain_entity.CovidInfoEntity
import com.moshenskyi.feature_covid_data.internal.network.CovidRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class CovidViewModel : ViewModel() {
	// TODO: 1/11/22 Inject in constructor
	private val useCase = GetCovidDataUseCase(CovidRepositoryImpl(), Dispatchers.IO)

	private val _state = MutableLiveData<ScreenState<List<CovidInfoEntity>>>()
	val state: LiveData<ScreenState<List<CovidInfoEntity>>> = _state

	fun getCountriesInfo() = viewModelScope.launch {
		_state.value = ScreenState.Loading()

		runCatching {
			useCase.execute(None())
		}.onFailure { error ->
			_state.value = ScreenState.Failure(error.message, error)
		}.onSuccess {
			_state.value = ScreenState.Success(it)
		}
	}

	fun onExpanded(position: Int) {
		_state.value?.let { infoList ->
			if (infoList is ScreenState.Success) {
				val result = infoList.result
				_state.value = ScreenState.Success(result.handleExpansion(position))
			}
		}
	}

	private fun List<CovidInfoEntity>.handleExpansion(position: Int): List<CovidInfoEntity> {
		val data = this.toMutableList()

		val viewData = data[position]
		val newItem = viewData.copy(expanded = viewData.expanded.not())

		data.removeAt(position)
		newItem.let { data.add(position, it) }

		return data
	}
}
