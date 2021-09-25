package com.moshenskyi.feature_covid_data.presentation.country_list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.moshenskyi.feature_covid_data.domain.model.CovidInfoEntity
import com.moshenskyi.feature_covid_data.presentation.country_list.diff_util.CovidDataDiffUtil
import com.moshenskyi.feature_covid_data.presentation.country_list.view_holder.CovidViewHolder

class CountryListAdapter(
	private val onExpanded: (Int) -> Unit,
) : ListAdapter<CovidInfoEntity, CovidViewHolder>(CovidDataDiffUtil()) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
		return CovidViewHolder.from(parent, onExpanded)
	}

	override fun onBindViewHolder(holder: CovidViewHolder, position: Int, payloads: MutableList<Any>) {
		if (payloads.isEmpty()) {
			onBindViewHolder(holder, position)
		} else {
			val changed = payloads.last() as Boolean
			if (changed) {
				holder.expand(getItem(position).expanded)
			}
		}
	}

	override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
		holder.bind(getItem(position))
	}
}
