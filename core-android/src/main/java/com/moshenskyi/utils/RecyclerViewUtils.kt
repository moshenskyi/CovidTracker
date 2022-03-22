package com.moshenskyi.utils

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

class DefaultLayoutManager(context: Context?) : LinearLayoutManager(context, VERTICAL, false)

class CustomizableDividerDecoration(
	context: Context,
	orientation: Int,
	drawableId: Int? = null
): DividerItemDecoration(context, orientation) {

	init {
		drawableId?.let {
			val drawable = ResourcesCompat.getDrawable(context.resources, drawableId, null)

			if (drawable != null) setDrawable(drawable)
		}
	}

}
