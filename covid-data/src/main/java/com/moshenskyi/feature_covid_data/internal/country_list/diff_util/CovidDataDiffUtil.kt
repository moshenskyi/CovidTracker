package com.moshenskyi.feature_covid_data.internal.country_list.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.moshenskyi.feature_covid_data.internal.domain_entity.CovidInfoEntity

internal class CovidDataDiffUtil : DiffUtil.ItemCallback<CovidInfoEntity>() {
	override fun areItemsTheSame(oldItem: CovidInfoEntity, newItem: CovidInfoEntity): Boolean {
		return oldItem.country == newItem.country
	}

	override fun areContentsTheSame(oldItem: CovidInfoEntity, newItem: CovidInfoEntity): Boolean {
		return oldItem == newItem
	}

	override fun getChangePayload(oldItem: CovidInfoEntity, newItem: CovidInfoEntity): Any {
		return oldItem.expanded != newItem.expanded
	}
}
