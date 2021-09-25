package com.moshenskyi.feature_covid_data.presentation.country_list.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.moshenskyi.feature_covid_data.presentation.country_list.TitleViewData

class TitleViewDataDiffUtil : DiffUtil.ItemCallback<TitleViewData>() {
    override fun areItemsTheSame(oldItem: TitleViewData, newItem: TitleViewData): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: TitleViewData, newItem: TitleViewData): Boolean {
        return oldItem == newItem
    }
}
