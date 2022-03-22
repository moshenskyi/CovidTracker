package com.moshenskyi.feature_covid_data.internal.country_list.view_holder.chart_helper.test_chart

import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.moshenskyi.core.EMPTY_STRING

internal class PieDataSetCreator(private val dataSetConfig: DataSetConfig = DataSetConfig()) {

	fun create(testsCount: Int, population: Int): PieDataSet {
		val testsEntry = PieEntry(testsCount.toFloat(), TESTS_LABEL)
		val populationEntry = PieEntry(population.toFloat(), POPULATION_LABEL)

		val yVals = listOf(testsEntry, populationEntry)

		return PieDataSet(yVals, EMPTY_STRING).apply {
			colors = dataSetConfig.datasetColors
			form = dataSetConfig.legendForm
			sliceSpace = dataSetConfig.space
		}
	}
}
