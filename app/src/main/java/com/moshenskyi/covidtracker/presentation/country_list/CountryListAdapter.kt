package com.moshenskyi.covidtracker.presentation.country_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moshenskyi.covidtracker.R
import com.moshenskyi.covidtracker.domain.model.CovidInfoEntity

class CountryListAdapter() : RecyclerView.Adapter<CountryDetailsViewHolder>() {

    private var countryRecords = mutableListOf<CovidInfoEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryDetailsViewHolder {
        val item = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.country_item_outter, parent, false)
        return CountryDetailsViewHolder(item)
    }

    override fun onBindViewHolder(holder: CountryDetailsViewHolder, position: Int) {
        holder.bind(countryRecords[position])
    }

    override fun getItemCount() = countryRecords.size

    fun setItems(countryRecords: List<CovidInfoEntity>) {
        this.countryRecords.clear()
        this.countryRecords.addAll(countryRecords)
        notifyDataSetChanged()
    }
}