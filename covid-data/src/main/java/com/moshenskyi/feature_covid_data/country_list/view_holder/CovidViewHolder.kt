package com.moshenskyi.feature_covid_data.country_list.view_holder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.moshenskyi.feature_covid_data.R
import com.moshenskyi.feature_covid_data.country_list.view_holder.chart_helper.initTestChart
import com.moshenskyi.feature_covid_data.country_list.view_holder.chart_helper.initVaccinationChart
import com.moshenskyi.feature_covid_data.databinding.CovidListItemBinding
import com.moshenskyi.feature_covid_data.domain_entity.CovidInfoEntity

class CovidViewHolder(
	private val onExpanded: (Int) -> Unit,
	private val binding: CovidListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

	private val countryTitle: TextView = binding.countryTitle
	private val testChart: PieChart = binding.countryData.testCoverageChart
	private val vaccinationChart: LineChart = binding.countryData.vaccinationChart

	private val countryData: ViewGroup = binding.countryData.root

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
			val binding = CovidListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
			return CovidViewHolder(onExpanded, binding)
		}
	}
}
