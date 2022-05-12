package com.moshenskyi.covidtracker

import android.animation.Animator

class DefaultAnimator : Animator.AnimatorListener {
	internal var onAnimationFinished: (() -> Unit)? = null
	internal var onAnimationStarted: (() -> Unit)? = null
	internal var onAnimationCanceled: (() -> Unit)? = null
	internal var onAnimationRepeated: (() -> Unit)? = null

	override fun onAnimationEnd(animation: Animator?) {
		onAnimationFinished?.invoke()
	}

	override fun onAnimationStart(animation: Animator?) {
		onAnimationStarted?.invoke()
	}

	override fun onAnimationCancel(animation: Animator?) {
		onAnimationCanceled?.invoke()
	}

	override fun onAnimationRepeat(animation: Animator?) {
		onAnimationRepeated?.invoke()
	}

}

fun DefaultAnimator.onAnimationFinished(action: () -> Unit): DefaultAnimator {
	onAnimationFinished = action
	return this
}

fun DefaultAnimator.onAnimationStarted(action: () -> Unit): DefaultAnimator {
	onAnimationStarted = action
	return this
}

fun DefaultAnimator.onAnimationCanceled(action: () -> Unit): DefaultAnimator {
	onAnimationCanceled = action
	return this
}

fun DefaultAnimator.onAnimationRepeated(action: () -> Unit): DefaultAnimator {
	onAnimationRepeated = action
	return this
}
