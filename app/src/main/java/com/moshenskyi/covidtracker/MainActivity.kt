package com.moshenskyi.covidtracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.moshenskyi.feature_covid_data.presentation.CovidDataFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
            supportFragmentManager.commit {
                add<CovidDataFragment>(R.id.fragment_container, "covid_data")
            }
        }
    }
}