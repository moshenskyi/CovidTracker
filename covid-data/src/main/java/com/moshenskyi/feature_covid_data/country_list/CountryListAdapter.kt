package com.moshenskyi.feature_covid_data.country_list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.moshenskyi.feature_covid_data.country_list.diff_util.CovidDataDiffUtil
import com.moshenskyi.feature_covid_data.country_list.view_holder.CovidViewHolder
import com.moshenskyi.feature_covid_data.domain_entity.CovidInfoEntity

internal class CountryListAdapter(
    private val onExpanded: (Int) -> Unit
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
				val item = getItem(position)
				holder.expand(item.expanded)
            }
        }
    }

    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
