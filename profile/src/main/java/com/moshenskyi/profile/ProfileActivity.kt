package com.moshenskyi.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.moshenskyi.profile.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
	private var binding: ActivityProfileBinding? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityProfileBinding.inflate(layoutInflater)
		setContentView(binding?.root)
	}

	override fun onDestroy() {
		super.onDestroy()

		binding = null
	}

	companion object {
		fun start(context: Context) {
			val starter = Intent(context, ProfileActivity::class.java)
			context.startActivity(starter)
		}
	}
}
