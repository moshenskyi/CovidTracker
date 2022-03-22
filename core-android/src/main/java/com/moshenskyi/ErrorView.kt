package com.moshenskyi

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.moshenskyi.core.ScreenState.Failure
import com.moshenskyi.core_android.R

class ErrorView @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
) : LinearLayout(context, attrs) {

	internal var errorTextView: TextView? = null
	internal var errorImageView: ImageView? = null

	private val errorAdapter = ErrorViewAdapter()

	init {
		inflate(context, R.layout.view_error, this)
	}

	override fun onFinishInflate() {
		super.onFinishInflate()

		gravity = Gravity.CENTER
		orientation = VERTICAL

		errorTextView = findViewById(R.id.error_text)
		errorImageView = findViewById(R.id.error_image)
	}

	fun <T : Any> setError(error: Failure<T>) {
		errorAdapter.setError(this, error)
	}


}
