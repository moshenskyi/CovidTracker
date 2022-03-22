package com.moshenskyi

import androidx.core.content.res.ResourcesCompat
import com.moshenskyi.core.ConnectionError
import com.moshenskyi.core.ScreenState.Failure
import com.moshenskyi.core_android.R

class ErrorViewAdapter {

	fun <T : Any> setError(errorView: ErrorView?, error: Failure<T>) {
		errorView?.let { view ->
			when (error.underlyingError) {
				is ConnectionError -> updateResources(view, error.message, R.drawable.connection_error)
				else -> updateResources(view, error.message, R.drawable.server_error)
			}
		}
	}

	private fun updateResources(view: ErrorView, message: String?, drawableId: Int) {
		val drawable = ResourcesCompat.getDrawable(view.resources, drawableId, null)
		view.errorImageView?.setImageDrawable(drawable)
		view.errorTextView?.text = message
	}

}
