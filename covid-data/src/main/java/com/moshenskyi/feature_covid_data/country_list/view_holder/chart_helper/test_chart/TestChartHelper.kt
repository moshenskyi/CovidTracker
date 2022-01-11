package com.moshenskyi.feature_covid_data.country_list.view_holder.chart_helper.test_chart

import android.graphics.Color
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.formatter.PercentFormatter
import com.moshenskyi.core.EMPTY_STRING

internal class TestChartHelper {

	fun initTestChart(testChart: PieChart, testsCount: Int, population: Int) {
		with(testChart) {
			setUsePercentValues(true)
			setHoleColor(Color.WHITE)

			isHighlightPerTapEnabled = true

			setupAngles()
			setupAnimations()
			setupTextAppearance()

			data = configurePieData(testsCount, population, testChart)
			invalidate()
		}
	}

	private fun PieChart.setupAnimations() {
		dragDecelerationFrictionCoef = DECELERATION_COEFFICIENT
		animateY(ANIMATION_SPEED, Easing.EaseInOutQuad)
	}

	private fun PieChart.setupTextAppearance() {
		setDrawCenterText(false)
		setDrawEntryLabels(false)
		description = Description().apply { text = EMPTY_STRING }
	}

	private fun PieChart.setupAngles() {
		holeRadius = HOLE_RADIUS
		rotationAngle = ROTATION_ANGLE
		minAngleForSlices = MIN_ANGLE_FOR_SLICES
		isRotationEnabled = true
	}

	private fun configurePieData(
		testsCount: Int,
		population: Int,
		testChart: PieChart,
	): PieData {
		val dataSet = PieDataSetCreator().create(testsCount, population)
		val pieData = PieData(dataSet)
		val dataFormatter = PieDataFormatter(
			PieDataConfig(valueFormatter = PercentFormatter(testChart))
		)
		dataFormatter.format(pieData)
		return pieData
	}

}
