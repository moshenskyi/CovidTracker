package com.moshenskyi.feature_covid_data.internal.country_list.view_holder.chart_helper.test_chart

import com.github.mikephil.charting.data.PieData

internal class PieDataFormatter constructor(
	private val configs: PieDataConfig = PieDataConfig()
) {

	fun format(pieData: PieData) {
		configs.valueFormatter?.let {
			pieData.setValueFormatter(it)
		}
		pieData.setValueTextSize(configs.valueTextSize)
		pieData.setValueTextColor(configs.valueTextColor)
	}
}
