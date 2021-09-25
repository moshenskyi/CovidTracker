package com.moshenskyi.feature_covid_data.presentation.view_model

import com.moshenskyi.feature_covid_data.domain.model.CovidInfoEntity
import com.moshenskyi.feature_covid_data.presentation.country_list.ChartViewData
import com.moshenskyi.feature_covid_data.presentation.country_list.ItemViewData
import com.moshenskyi.feature_covid_data.presentation.country_list.TitleViewData

fun map(info: List<CovidInfoEntity>): List<ItemViewData> {
    val dataList = mutableListOf<ItemViewData>()

    info.forEach { entity ->
        dataList.add(TitleViewData(entity.country, false))
        dataList.add(ChartViewData(entity.testCount, entity.population, entity.vaccineCapacityInfoItem))
    }

    return dataList
}
