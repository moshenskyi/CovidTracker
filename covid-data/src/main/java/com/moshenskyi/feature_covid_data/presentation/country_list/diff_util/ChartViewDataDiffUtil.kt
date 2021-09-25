package com.moshenskyi.feature_covid_data.presentation.country_list.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.moshenskyi.feature_covid_data.presentation.country_list.ChartViewData

class ChartViewDataDiffUtil : DiffUtil.ItemCallback<ChartViewData>() {
    override fun areItemsTheSame(oldItem: ChartViewData, newItem: ChartViewData): Boolean {
        return oldItem.vaccineCapacityInfoItem?.country == newItem.vaccineCapacityInfoItem?.country
    }

    override fun areContentsTheSame(oldItem: ChartViewData, newItem: ChartViewData): Boolean {
        return oldItem == newItem
    }
}
