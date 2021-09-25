package com.moshenskyi.feature_covid_data.presentation.country_list.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.moshenskyi.feature_covid_data.presentation.country_list.ItemViewData

abstract class ItemViewHolder<in T : ItemViewData>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(viewData: T, expanded: Boolean)
}
