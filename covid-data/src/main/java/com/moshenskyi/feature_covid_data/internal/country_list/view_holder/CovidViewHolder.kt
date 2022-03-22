package com.moshenskyi.feature_covid_data.internal.country_list.view_holder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.moshenskyi.feature_covid_data.R
import com.moshenskyi.feature_covid_data.databinding.CovidListItemBinding
import com.moshenskyi.feature_covid_data.internal.country_list.view_holder.chart_helper.initVaccinationChart
import com.moshenskyi.feature_covid_data.internal.country_list.view_holder.chart_helper.test_chart.TestChartHelper
import com.moshenskyi.feature_covid_data.internal.domain_entity.CovidInfoEntity

internal class CovidViewHolder(
	private val onExpanded: (Int) -> Unit,
	binding: CovidListItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

	private val countryTitle: TextView = binding.countryTitle
	private val testChart: PieChart = binding.countryData.testCoverageChart
	private val vaccinationChart: LineChart = binding.countryData.vaccinationChart

	private val countryData: ViewGroup = binding.countryData.root

	private val testChartHelper = TestChartHelper()

	private val animationHelper = ChartItemAnimationHelper(
		countryData,
		{ countryTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expanded, 0) },
		{ countryTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_hidden, 0) }
	)

	private val animationController = AnimationController.withHelper(animationHelper)

	fun bind(viewData: CovidInfoEntity) {
		countryTitle.text = viewData.country

		testChartHelper.initTestChart(testChart, viewData.testCount, viewData.population)
		initVaccinationChart(vaccinationChart, viewData.vaccineCapacityInfoItem?.timeline)

		expand(viewData.expanded)

		itemView.setOnClickListener {
			onExpanded(adapterPosition)
		}
	}

	fun expand(expanded: Boolean) {
		animationController.expand(expanded)
	}

	companion object {
		fun from(parent: ViewGroup, onExpanded: (Int) -> Unit): CovidViewHolder {
			val binding = CovidListItemBinding.inflate(
				LayoutInflater.from(parent.context),
				parent,
				false
			)
			return CovidViewHolder(onExpanded, binding)
		}
	}
}
