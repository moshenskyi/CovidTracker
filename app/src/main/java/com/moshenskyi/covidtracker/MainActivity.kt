package com.moshenskyi.covidtracker

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.moshenskyi.covidtracker.databinding.ActivityMainBinding
import com.moshenskyi.feature_covid_data.routing.CovidDataRouterImpl
import com.moshenskyi.profile.ProfileActivity
import com.moshenskyi.sign_in.AuthRouterImpl

class MainActivity : AppCompatActivity() {

	private val authRouter = AuthRouterImpl()
	private val covidDataRouter = CovidDataRouterImpl()

	private var binding: ActivityMainBinding? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding?.root)

		setSupportActionBar(binding?.toolbar)

		authRouter.openAuth(this)

		covidDataRouter.openCovidData(supportFragmentManager, R.id.fragment_container)
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.profile_menu, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
		R.id.profile -> {
			ProfileActivity.start(this)
			true
		}
		else -> super.onOptionsItemSelected(item)
	}

	override fun onBackPressed() {
		if (onBackPressedDispatcher.hasEnabledCallbacks()) {
			super.onBackPressed()
		}
	}

	override fun onDestroy() {
		super.onDestroy()
		binding = null
	}
}
