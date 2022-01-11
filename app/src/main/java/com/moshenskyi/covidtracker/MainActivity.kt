package com.moshenskyi.covidtracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.moshenskyi.feature_covid_data.covid_data.CovidDataRouterImpl
import com.moshenskyi.feature_covid_data.routing.CovidDataRouterImpl
import com.moshenskyi.sign_in.AuthRouterImpl

class MainActivity : AppCompatActivity(R.layout.activity_main) {

	private val authRouter = AuthRouterImpl()
	private val covidDataRouter = CovidDataRouterImpl()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		authRouter.openAuth(this)

		covidDataRouter.openCovidData(supportFragmentManager, R.id.fragment_container)
	}
}
