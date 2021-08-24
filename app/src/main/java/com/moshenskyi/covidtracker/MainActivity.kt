package com.moshenskyi.covidtracker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.moshenskyi.feature_covid_data.presentation.CovidDataFragment
import com.moshenskyi.sign_in.AuthActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private var loginLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginLauncher =
            registerForActivityResult(StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    // TODO: 8/23/21 Save name and email
                }
            }


        lifecycleScope.launchWhenCreated {
            loginLauncher?.launch(Intent(this@MainActivity, AuthActivity::class.java))
        }

        if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
            supportFragmentManager.commit {
                add<CovidDataFragment>(R.id.fragment_container, "covid_data")
            }
        }
    }
}