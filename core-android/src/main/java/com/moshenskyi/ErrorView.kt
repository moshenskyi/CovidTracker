package com.moshenskyi

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import com.moshenskyi.core_android.R

class ErrorView @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null
): LinearLayout(context, attrs) {

	private var errorTextView: TextView? = null

	var errorText: String?
		set(value) {
			errorTextView?.text = value
		}
		get() = errorTextView?.text.toString()

	init {
		inflate(context, R.layout.view_error, this)
	}

	override fun onFinishInflate() {
		super.onFinishInflate()

		gravity = Gravity.CENTER
		orientation = VERTICAL

		errorTextView = findViewById(R.id.error_text)
	}


}
