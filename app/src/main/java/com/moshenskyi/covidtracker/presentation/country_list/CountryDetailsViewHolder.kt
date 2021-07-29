package com.moshenskyi.covidtracker.presentation.country_list

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.moshenskyi.covidtracker.R
import com.moshenskyi.covidtracker.data.vaccine.Timeline
import com.moshenskyi.covidtracker.domain.model.CovidInfoEntity

class CountryDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val countryTitle: TextView = itemView.findViewById(R.id.country_title)
    private val testChart: PieChart = itemView.findViewById(R.id.test_coverage_chart)
    private val vaccinationChart: LineChart = itemView.findViewById(R.id.vaccination_chart)

    fun bind(countryRecords: CovidInfoEntity) {
        countryTitle.text = countryRecords.country
        initTestChart(countryRecords.testCount, countryRecords.population)
    }

    private fun initVaccinationChart(vaccineCapacityChart: LineChart, timeline: Timeline) {
        vaccineCapacityChart.description.isEnabled = false
    }

    private fun initTestChart(testsCount: Int, population: Int) {
        testChart.setUsePercentValues(true)
        testChart.dragDecelerationFrictionCoef = 0.95f
        testChart.setHoleColor(Color.WHITE)
        testChart.holeRadius = 57F
        testChart.rotationAngle = 0F
        testChart.isRotationEnabled = true
        testChart.isHighlightPerTapEnabled = true
        testChart.minAngleForSlices = 30f
        testChart.description = Description().apply { text = "" }
        testChart.setDrawCenterText(false)
        testChart.setDrawEntryLabels(false)
        testChart.setUsePercentValues(true)
        testChart.animateY(1400, Easing.EaseInOutQuad)

        val testsEntry = PieEntry(testsCount.toFloat(), "Tests")
        val populationEntry = PieEntry(population.toFloat(), "Population")

        val dataSet = PieDataSet(listOf(testsEntry, populationEntry), "")
        dataSet.setColors(Color.rgb(193, 37, 82), Color.rgb(255, 102, 0))
        dataSet.form = Legend.LegendForm.LINE
        dataSet.sliceSpace = 5f
        dataSet.valueLinePart1OffsetPercentage = 80f
        dataSet.valueLinePart1Length = 0.2f
        dataSet.valueLinePart2Length = 0.4f
        val pieData = PieData(dataSet)
        pieData.setValueFormatter(PercentFormatter(testChart))
        pieData.setValueTextSize(16f)
        pieData.setValueTextColor(Color.WHITE)
        testChart.data = pieData
        testChart.invalidate()
    }

}
