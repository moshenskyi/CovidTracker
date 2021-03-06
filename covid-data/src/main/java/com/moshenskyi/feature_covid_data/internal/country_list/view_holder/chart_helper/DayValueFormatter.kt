package com.moshenskyi.feature_covid_data.internal.country_list.view_holder.chart_helper

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.formatter.ValueFormatter

internal class DayValueFormatter(private val dataSet: LineData) : ValueFormatter() {

	override fun getAxisLabel(value: Float, axis: AxisBase?): String {
		val entryForIndex = dataSet.getDataSetByIndex(0).getEntryForIndex(value.toInt())
		return entryForIndex.data.toString()
	}
}
