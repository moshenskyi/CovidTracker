package com.moshenskyi.feature_covid_data.internal.country_list.view_holder.chart_helper.test_chart

import android.graphics.Color
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.formatter.ValueFormatter


internal data class DataSetConfig(
	var datasetColors: List<Int> = listOf(BRANDING_COLOR, ACCENT_COLOR),
	var legendForm: Legend.LegendForm = Legend.LegendForm.LINE,
	var space: Float = SLICE_OFFSET_SPACE
)

internal data class PieDataConfig(
	var valueFormatter: ValueFormatter? = null,
	var valueTextSize: Float = VALUE_TEXT_SIZE,
	var valueTextColor: Int = Color.WHITE
)
