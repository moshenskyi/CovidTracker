package com.moshenskyi.navigation.screen

import androidx.fragment.app.FragmentManager

interface CovidDataRouter {

	fun openCovidData(fragmentManager: FragmentManager, containerId: Int)

}
