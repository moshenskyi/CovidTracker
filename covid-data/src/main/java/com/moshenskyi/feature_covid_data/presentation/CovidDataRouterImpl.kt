package com.moshenskyi.feature_covid_data.presentation

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.moshenskyi.navigation.screen.CovidDataRouter

private const val FRAGMENT_TAG = "covid_data"

class CovidDataRouterImpl : CovidDataRouter {

	override fun openCovidData(fragmentManager: FragmentManager, containerId: Int) {
		if (fragmentManager.findFragmentById(containerId) == null) {
			fragmentManager.commit {
				add<CovidDataFragment>(containerId, FRAGMENT_TAG)
			}
		}
	}

}
