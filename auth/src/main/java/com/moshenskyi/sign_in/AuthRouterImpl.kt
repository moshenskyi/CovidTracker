package com.moshenskyi.sign_in

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import com.moshenskyi.navigation.screen.AuthRouter

class AuthRouterImpl : AuthRouter {
	private var loginLauncher: ActivityResultLauncher<Intent>? = null

	override fun openAuth(context: FragmentActivity) {
		loginLauncher =
			context.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
				if (result.resultCode == Activity.RESULT_OK) {
					// TODO: 8/23/21 Save name and email
				}
			}

		context.lifecycleScope.launchWhenCreated {
			loginLauncher?.launch(Intent(context, AuthActivity::class.java))
		}
	}

}
