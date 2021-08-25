package com.moshenskyi.feature_covid_data.presentation.country_list

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.formatter.ValueFormatter

class DayValueFormatter(private val dataSet: LineData): ValueFormatter() {

    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        val entryForIndex = dataSet.getDataSetByIndex(0).getEntryForIndex(value.toInt())
        return entryForIndex.data.toString()
    }

}