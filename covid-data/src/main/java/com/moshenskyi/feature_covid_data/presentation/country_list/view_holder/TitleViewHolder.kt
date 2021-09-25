package com.moshenskyi.feature_covid_data.presentation.country_list.view_holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moshenskyi.feature_covid_data.R
import com.moshenskyi.feature_covid_data.presentation.country_list.TitleViewData

class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val countryTitle: TextView = itemView.findViewById(R.id.country_title)

    fun bind(viewData: TitleViewData) {
        countryTitle.text = viewData.title

        itemView.setOnClickListener {

        }
    }

    companion object {
        fun from(parent: ViewGroup): TitleViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val item = layoutInflater.inflate(R.layout.covid_list_item, parent, false)

            return TitleViewHolder(item)
        }
    }
}
