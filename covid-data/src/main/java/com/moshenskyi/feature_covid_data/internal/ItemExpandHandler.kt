package com.moshenskyi.feature_covid_data.covid_data

import com.moshenskyi.feature_covid_data.internal.domain_entity.CovidInfoEntity

internal fun handleExpansion(position: Int, infoList: List<CovidInfoEntity>): List<CovidInfoEntity> {
	val data = infoList.toMutableList()

	val viewData = data[position]
	val newItem = viewData.copy(expanded = viewData.expanded.not())

	data.removeAt(position)
	newItem.let { data.add(position, it) }

	return data
}
