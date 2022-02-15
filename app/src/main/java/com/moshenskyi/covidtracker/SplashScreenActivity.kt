package com.moshenskyi.covidtracker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.moshenskyi.covidtracker.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val binding = ActivitySplashScreenBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.root.addAnimatorListener(
			DefaultAnimator().onAnimationFinished {
				startActivity(Intent(this, MainActivity::class.java))
			})
	}
}
