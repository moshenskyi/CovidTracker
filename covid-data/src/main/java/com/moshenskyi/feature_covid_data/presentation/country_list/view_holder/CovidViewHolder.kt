package com.moshenskyi.feature_covid_data.presentation.country_list.view_holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.moshenskyi.feature_covid_data.R
import com.moshenskyi.feature_covid_data.domain.model.CovidInfoEntity
import com.moshenskyi.feature_covid_data.presentation.country_list.view_holder.chart_helper.initTestChart
import com.moshenskyi.feature_covid_data.presentation.country_list.view_holder.chart_helper.initVaccinationChart

class CovidViewHolder(
	private val onExpanded: (Int) -> Unit,
	itemView: View
) : RecyclerView.ViewHolder(itemView) {

	private val countryTitle: TextView = itemView.findViewById(R.id.country_title)
	private val testChart: PieChart = itemView.findViewById(R.id.test_coverage_chart)
	private val vaccinationChart: LineChart = itemView.findViewById(R.id.vaccination_chart)

	private val countryData: ViewGroup = itemView.findViewById(R.id.country_data)

	private var expanded = false

	private val animationHelper = AnimationHelper(
		countryData,
		{ countryTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expanded, 0) },
		{ countryTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_hidden, 0) }
	)

	fun bind(viewData: CovidInfoEntity) {
		countryTitle.text = viewData.country

		initTestChart(testChart, viewData.testCount, viewData.population)
		initVaccinationChart(vaccinationChart, viewData.vaccineCapacityInfoItem?.timeline)

		expand(viewData.expanded)

		itemView.setOnClickListener {
			onExpanded(adapterPosition)
		}
	}

	fun expand(expanded: Boolean) {
		if (this.expanded != expanded) {
			this.expanded = expanded
			animateExpand(expanded)
		}
	}

	private fun animateExpand(expanded: Boolean) {
		if (expanded) {
			animationHelper.showDetails()
		} else {
			animationHelper.hideDetails()
		}
	}

	companion object {
		fun from(parent: ViewGroup, onExpanded: (Int) -> Unit): CovidViewHolder {
			val layoutInflater = LayoutInflater.from(parent.context)
			val item = layoutInflater.inflate(R.layout.covid_list_item, parent, false)

			return CovidViewHolder(onExpanded, item)
		}
	}
}
