package com.moshenskyi.feature_covid_data.presentation.country_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.moshenskyi.feature_covid_data.R
import com.moshenskyi.feature_covid_data.domain.model.CovidInfoEntity

class CountryDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val countryTitle: TextView = itemView.findViewById(R.id.country_title)
    private val testChart: PieChart = itemView.findViewById(R.id.test_coverage_chart)
    private val vaccinationChart: LineChart = itemView.findViewById(R.id.vaccination_chart)

    fun bind(countryRecords: CovidInfoEntity) {
        countryTitle.text = countryRecords.country
        initTestChart(testChart, countryRecords.testCount, countryRecords.population)
        initVaccinationChart(vaccinationChart, countryRecords.vaccineCapacityInfoItem?.timeline)
    }

    companion object {
        fun from(parent: ViewGroup): CountryDetailsViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val item = layoutInflater.inflate(R.layout.country_item_outter, parent, false)

            return CountryDetailsViewHolder(item)
        }
    }
}
