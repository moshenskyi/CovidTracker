package com.moshenskyi.feature_covid_data.presentation.country_list

import com.moshenskyi.feature_covid_data.data.model.vaccine.VaccineCapacityInfoItem

interface ItemViewData

data class TitleViewData(val title: String, var isExpanded: Boolean) : ItemViewData

data class ChartViewData(
    val testCount: Int,
    val population: Int,
    val vaccineCapacityInfoItem: VaccineCapacityInfoItem?
) : ItemViewData
