package com.moshenskyi.feature_covid_data.presentation.country_list

import android.graphics.Color
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.moshenskyi.core.EMPTY_STRING

// region Constants

// region ANIMATION
private const val DECELERATION_COEFFICIENT = 0.95F
private const val ANIMATION_SPEED = 1_400
// endregion

// region SIZE
private const val HOLE_RADIUS = 57F
private const val ROTATION_ANGLE = 0F
private const val MIN_ANGLE_FOR_SLICES = 30F
private const val SLICE_OFFSET_SPACE = 5F

private const val VALUE_TEXT_SIZE = 14F

// endregion

// region LABELS
private const val TESTS_LABEL = "Tests"
private const val POPULATION_LABEL = "Population"
// endregion

// region COLORS
private val ACCENT_COLOR = Color.rgb(193, 37, 82)
private val BRANDING_COLOR = Color.rgb(104, 241, 175)
//endregion

// endregion

fun initTestChart(testChart: PieChart, testsCount: Int, population: Int) {
    val dataSet = createDataSet(testsCount, population)
    val pieData = createPieData(dataSet, testChart)

    with(testChart) {
        setUsePercentValues(true)
        setHoleColor(Color.WHITE)

        isHighlightPerTapEnabled = true

        holeRadius = HOLE_RADIUS
        rotationAngle = ROTATION_ANGLE
        minAngleForSlices = MIN_ANGLE_FOR_SLICES
        isRotationEnabled = true

        dragDecelerationFrictionCoef = DECELERATION_COEFFICIENT
        animateY(ANIMATION_SPEED, Easing.EaseInOutQuad)

        setDrawCenterText(false)
        setDrawEntryLabels(false)
        description = Description().apply { text = EMPTY_STRING }

        data = pieData
        invalidate()
    }
}

private fun createPieData(
    dataSet: PieDataSet,
    testChart: PieChart
): PieData {
    val pieData = PieData(dataSet)
    pieData.setValueFormatter(PercentFormatter(testChart))
    pieData.setValueTextSize(VALUE_TEXT_SIZE)
    pieData.setValueTextColor(Color.WHITE)
    return pieData
}

private fun createDataSet(testsCount: Int, population: Int): PieDataSet {
    val testsEntry = PieEntry(testsCount.toFloat(), TESTS_LABEL)
    val populationEntry = PieEntry(population.toFloat(), POPULATION_LABEL)

    return PieDataSet(listOf(testsEntry, populationEntry), EMPTY_STRING). apply {
        setColors(BRANDING_COLOR, ACCENT_COLOR)
        form = Legend.LegendForm.LINE
        sliceSpace = SLICE_OFFSET_SPACE
    }
}