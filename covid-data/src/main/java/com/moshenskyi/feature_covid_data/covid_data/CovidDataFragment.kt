package com.moshenskyi.feature_covid_data.covid_data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.moshenskyi.core.ScreenState
import com.moshenskyi.core.ScreenState.Failure
import com.moshenskyi.core.ScreenState.Success
import com.moshenskyi.feature_covid_data.databinding.FragmentCovidDataBinding
import com.moshenskyi.feature_covid_data.internal.CovidViewModel
import com.moshenskyi.feature_covid_data.internal.country_list.CountryListAdapter
import com.moshenskyi.feature_covid_data.internal.domain_entity.CovidInfoEntity
import com.moshenskyi.utils.DefaultLayoutManager

class CovidDataFragment : Fragment() {
	private val viewModel by viewModels<CovidViewModel> { defaultViewModelProviderFactory }

	private var listAdapter: CountryListAdapter? = null

	private var binding: FragmentCovidDataBinding? = null

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		binding = FragmentCovidDataBinding.inflate(layoutInflater)
		return binding?.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initRecycler()

		with(viewModel) {
			getCountriesInfo()
			state.observe(viewLifecycleOwner, ::handleScreenState)
		}
	}

	private fun handleScreenState(screenState: ScreenState<List<CovidInfoEntity>>) {
		when (screenState) {
			is Success -> {
				onListLoaded(screenState.result)
			}
			is Failure -> {
				onListLoadingFailed(screenState)
			}
			else -> {
				binding?.loadingView?.isVisible = true
				binding?.errorView?.isVisible = false
			}
		}
	}

	private fun onListLoaded(list: List<CovidInfoEntity>) {
		binding?.loadingView?.isVisible = false
		binding?.countryList?.isVisible = true
		binding?.errorView?.isVisible = false
		listAdapter?.submitList(list)
	}

	private fun onListLoadingFailed(error: Failure<List<CovidInfoEntity>>) {
		binding?.loadingView?.isVisible = false
		binding?.countryList?.isVisible = false
		binding?.errorView?.run {
			isVisible = true
			setError(error)
		}
	}

	private fun initRecycler() {
		val countryRecyclerView = binding?.countryList
		listAdapter = CountryListAdapter(viewModel::onExpanded)

		countryRecyclerView?.run {
			layoutManager = DefaultLayoutManager(activity)
			setHasFixedSize(true)
			adapter = listAdapter
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()

		binding = null
	}
}
