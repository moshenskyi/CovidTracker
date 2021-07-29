package com.moshenskyi.covidtracker.presentation.country_list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.moshenskyi.covidtracker.domain.model.CovidInfoEntity

class CountryListAdapter : ListAdapter<CovidInfoEntity, CountryDetailsViewHolder>(CovidInfoEntityDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryDetailsViewHolder {
        return CountryDetailsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CountryDetailsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}