package com.moshenskyi.feature_covid_data.covid_data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.moshenskyi.feature_covid_data.country_list.CountryListAdapter
import com.moshenskyi.feature_covid_data.databinding.FragmentCovidDataBinding

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
			infoLiveData.observe(viewLifecycleOwner) { data ->
				// TODO: 7/18/21 Check if empty
				listAdapter?.submitList(data)
			}
		}
	}

	private fun initRecycler() {
		val countryRecyclerView = binding?.countryList
		listAdapter = CountryListAdapter(viewModel::onExpanded)

		countryRecyclerView?.run {
			layoutManager = LinearLayoutManager(
				activity,
				LinearLayoutManager.VERTICAL,
				false
			)
			setHasFixedSize(true)
			adapter = listAdapter
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()

		binding = null
	}
}
