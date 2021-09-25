package com.moshenskyi.feature_covid_data.presentation.country_list.view_holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.moshenskyi.feature_covid_data.R
import com.moshenskyi.feature_covid_data.presentation.country_list.ChartViewData
import com.moshenskyi.feature_covid_data.presentation.country_list.initTestChart
import com.moshenskyi.feature_covid_data.presentation.country_list.initVaccinationChart

class ChartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val testChart: PieChart = itemView.findViewById(R.id.test_coverage_chart)
    private val vaccinationChart: LineChart = itemView.findViewById(R.id.vaccination_chart)

    private fun hideItemView() {
        itemView.visibility = View.GONE
        itemView.layoutParams = RecyclerView.LayoutParams(0, 0)
    }

    private fun showItemView() {
        itemView.visibility = View.VISIBLE
        itemView.layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun bind(viewData: ChartViewData, expanded: Boolean) {
        if (expanded) {
            showItemView()
            initTestChart(testChart, viewData.testCount, viewData.population)
            initVaccinationChart(vaccinationChart, viewData.vaccineCapacityInfoItem?.timeline)
        } else {
            hideItemView()
        }
    }

    companion object {
        fun from(parent: ViewGroup): ChartViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val item = layoutInflater.inflate(R.layout.chart_item, parent, false)

            return ChartViewHolder(item)
        }
    }
}
