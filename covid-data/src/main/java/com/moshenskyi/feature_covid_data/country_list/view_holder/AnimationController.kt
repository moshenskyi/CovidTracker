package com.moshenskyi.feature_covid_data.country_list.view_holder

internal class AnimationController private constructor(private val animationHelper: ChartItemAnimationHelper) {
	private var expanded = false

	fun expand(expanded: Boolean) {
		if (this.expanded != expanded) {
			this.expanded = expanded
			animateExpand(expanded)
		}
	}

	private fun animateExpand(expanded: Boolean) {
		if (expanded) {
			animationHelper.showDetails()
		} else {
			animationHelper.hideDetails()
		}
	}

	companion object {
		fun withHelper(animationHelper: ChartItemAnimationHelper) = AnimationController(animationHelper)
	}
}
