package com.moshenskyi.feature_covid_data.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moshenskyi.feature_covid_data.R
import com.moshenskyi.feature_covid_data.presentation.country_list.CountryListAdapter

class CovidDataFragment : Fragment(R.layout.fragment_covid_data) {
	private val listAdapter = CountryListAdapter()

	private val viewModel by viewModels<CovidViewModel> { defaultViewModelProviderFactory }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		initRecycler(view)

		with(viewModel) {
			getCountriesInfo()
			infoLiveData.observe(viewLifecycleOwner) { data ->
				// TODO: 7/18/21 Check if empty
				listAdapter.submitList(data)
			}
		}
	}

	private fun initRecycler(view: View) {
		val countryRecyclerView = view.findViewById<RecyclerView>(R.id.country_list)

		with(countryRecyclerView) {
			layoutManager = LinearLayoutManager(
				activity,
				LinearLayoutManager.VERTICAL,
				false
			)
			adapter = listAdapter
		}
	}
}
