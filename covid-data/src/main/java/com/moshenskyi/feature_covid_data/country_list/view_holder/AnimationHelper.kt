package com.moshenskyi.feature_covid_data.country_list.view_holder

import android.animation.ObjectAnimator
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import androidx.core.animation.doOnCancel
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart

private const val ANIMATION_DURATION = 1_000L

private const val ALPHA_VISIBLE = 1.0F
private const val ALPHA_INVISIBLE = 0F

private const val ALPHA_PROPERTY = "alpha"

class AnimationHelper(private val container: ViewGroup, showAction: () -> Unit, hideAction: () -> Unit) {
	private val showAnimator = ObjectAnimator.ofFloat(container, ALPHA_PROPERTY, ALPHA_INVISIBLE, ALPHA_VISIBLE).apply {
		duration = ANIMATION_DURATION
		interpolator = AccelerateInterpolator()

		setShowCallbacks(showAction)
	}

	private val hideAnimator = ObjectAnimator.ofFloat(container, ALPHA_PROPERTY, ALPHA_VISIBLE, ALPHA_INVISIBLE).apply {
		duration = ANIMATION_DURATION
		interpolator = AccelerateInterpolator()
		setHideCallbacks(hideAction)
	}

	private fun ObjectAnimator.setShowCallbacks(showAction: () -> Unit) {
		doOnCancel {
			container.alpha = ALPHA_VISIBLE
			showAction()
		}
		doOnStart { showAction() }
	}

	private fun ObjectAnimator.setHideCallbacks(hideAction: () -> Unit) {
		doOnStart { hideAction() }
		doOnCancel {
			container.visibility = View.GONE
			hideAction()
		}
		doOnEnd {
			container.visibility = View.GONE
		}
	}

	fun hideDetails() {
		cancelPendingAnimations()
		hideAnimator.start()
	}

	fun showDetails() {
		cancelPendingAnimations()
		container.visibility = View.VISIBLE
		showAnimator.start()
	}

	private fun cancelPendingAnimations() {
		showAnimator.cancel()
		hideAnimator.cancel()
	}
}
