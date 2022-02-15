package com.moshenskyi.feature_covid_data.internal

import com.moshenskyi.feature_covid_data.internal.domain_entity.CovidInfoEntity

internal fun List<CovidInfoEntity>.handleExpansion(position: Int): List<CovidInfoEntity> {
	val data = this.toMutableList()

	val viewData = data[position]
	val newItem = viewData.copy(expanded = viewData.expanded.not())

	data.removeAt(position)
	newItem.let { data.add(position, it) }

	return data
}
