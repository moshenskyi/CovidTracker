package com.moshenskyi.feature_covid_data.internal.country_list

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration

fun createItemDecoration(context: Context, orientation: Int, drawableId: Int): DividerItemDecoration {
	return DividerItemDecoration(context, orientation).apply {
		val drawable = ResourcesCompat.getDrawable(context.resources, drawableId, null)

		if (drawable != null) setDrawable(drawable)
	}
}
