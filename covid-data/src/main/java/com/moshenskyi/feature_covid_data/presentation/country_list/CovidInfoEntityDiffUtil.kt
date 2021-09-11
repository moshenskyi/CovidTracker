package com.moshenskyi.feature_covid_data.presentation.country_list

import androidx.recyclerview.widget.DiffUtil
import com.moshenskyi.feature_covid_data.domain.model.CovidInfoEntity

class CovidInfoEntityDiffUtil : DiffUtil.ItemCallback<CovidInfoEntity>() {
    override fun areItemsTheSame(oldItem: CovidInfoEntity, newItem: CovidInfoEntity): Boolean {
        return oldItem.country == newItem.country
    }

    override fun areContentsTheSame(oldItem: CovidInfoEntity, newItem: CovidInfoEntity): Boolean {
        return oldItem == newItem
    }
}
