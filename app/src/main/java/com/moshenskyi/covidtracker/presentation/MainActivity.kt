package com.moshenskyi.covidtracker.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moshenskyi.covidtracker.R
import com.moshenskyi.covidtracker.presentation.country_list.CountryListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var countryRecyclerView: RecyclerView
    private val adapter = CountryListAdapter()

    private val viewModel by viewModels<CovidViewModel> { defaultViewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryRecyclerView = findViewById(R.id.country_list)
        initRecycler()

        viewModel.getCountriesInfo()
        viewModel.infoLiveData.observe(this, {
            // TODO: 7/18/21 Check if empty
            adapter.submitList(it)
        })
//        getStr
    }

    private fun initRecycler() {
        countryRecyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        countryRecyclerView.adapter = adapter
    }

}