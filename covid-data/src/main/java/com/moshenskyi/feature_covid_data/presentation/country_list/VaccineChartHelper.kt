package com.moshenskyi.feature_covid_data.presentation.country_list

import android.graphics.Color
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IFillFormatter

// TODO: 8/1/21 Rearrange
private const val MAX_HIGHLIGHT_DISTANCE = 300F
private const val NO_OFFSET = 0F

private val BACKGROUND_COLOR = Color.rgb(104, 241, 175)
private val HIGHLIGHT_COLOR = Color.rgb(244, 117, 117)

private const val FILL_ALPHA = 100

private const val LABEL_COUNT = 6

private const val ANIMATION_DURATION = 2000

private const val LINE_WIDTH = 1.8F
private const val VALUE_TEXT_SIZE = 9F
private const val CIRCLE_RADIUS = 4F

fun initVaccinationChart(vaccineCapacityChart: LineChart, timeline: Map<String, Int>?) {
    with(vaccineCapacityChart) {
        setViewPortOffsets(NO_OFFSET, NO_OFFSET, NO_OFFSET, NO_OFFSET)
        setBackgroundColor(BACKGROUND_COLOR)

        // no description text
        description.isEnabled = false
        setTouchEnabled(true)
        setScaleEnabled(true)
        isDragEnabled = true
        setPinchZoom(false)
        setDrawGridBackground(false)
        axisRight.isEnabled = false
        legend.isEnabled = false
        setMaxVisibleValueCount(LABEL_COUNT)

        maxHighlightDistance = MAX_HIGHLIGHT_DISTANCE

        animateXY(ANIMATION_DURATION, ANIMATION_DURATION)
    }

    setData(vaccineCapacityChart, timeline)

    initAxes(vaccineCapacityChart)

    // don't forget to refresh the drawing
    vaccineCapacityChart.invalidate()
}

private fun initAxes(vaccineCapacityChart: LineChart) {
    initXAxis(vaccineCapacityChart)
    initYAxis(vaccineCapacityChart)
}

private fun initYAxis(
    vaccineCapacityChart: LineChart,
) = with(vaccineCapacityChart.axisLeft) {
    setLabelCount(LABEL_COUNT, false)
    textColor = Color.BLACK
    setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART)
    axisLineColor = Color.WHITE
}

private fun initXAxis(
    vaccineCapacityChart: LineChart,
) = with(vaccineCapacityChart.xAxis) {
    setLabelCount(LABEL_COUNT, false)
    textColor = Color.BLACK
    position = XAxis.XAxisPosition.BOTTOM_INSIDE
    axisLineColor = Color.WHITE
    setAvoidFirstLastClipping(true)

    valueFormatter = DayValueFormatter(vaccineCapacityChart.data)
}


// TODO: 8/1/21 Rearrange
private fun setData(vaccineCapacityChart: LineChart, timeline: Map<String, Int>?) {
    timeline?.toDataSet()?.let {
        val set = LineDataSet(it, "Timelines").apply {
            mode = LineDataSet.Mode.CUBIC_BEZIER
            setDrawFilled(true)
            setDrawCircles(false)
            lineWidth = LINE_WIDTH
            circleRadius = CIRCLE_RADIUS
            setColorSettings()
            setDrawHorizontalHighlightIndicator(false)
            fillFormatter =
                IFillFormatter { _, _ -> vaccineCapacityChart.axisLeft.axisMinimum }
        }

        vaccineCapacityChart.data = LineData(set).apply {
            setValueTextSize(VALUE_TEXT_SIZE)
            setDrawValues(false)
        }
    }
}

fun LineDataSet.setColorSettings() {
    setCircleColor(Color.WHITE)
    highLightColor = HIGHLIGHT_COLOR
    color = Color.WHITE
    fillColor = Color.WHITE
    fillAlpha = FILL_ALPHA
}

// TODO: Check if not more than LABEL_COUNT
fun Map<String, Int>.toDataSet(): List<Entry> {
    val dataSet = mutableListOf<Entry>()

    var counter = 0F
    for (value in this.entries) {
        dataSet.add(Entry(counter++, value.value.toFloat(), value.key))
    }

    return dataSet
}