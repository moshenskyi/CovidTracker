package com.moshenskyi.covidtracker.presentation.country_list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moshenskyi.covidtracker.R

class CountryViewHolder(
    itemView: View,
    private val clickListener: (String) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val countryTitle: TextView = itemView.findViewById(R.id.country_title)

    fun bind(countryItem: String) {
        itemView.setOnClickListener{ clickListener(countryItem) }
        countryTitle.text = countryItem
    }
}