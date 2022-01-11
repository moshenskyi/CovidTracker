package com.moshenskyi.sign_in

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.SignInButton
import com.moshenskyi.sign_in.databinding.ActivityAuthBinding
import com.moshenskyi.sign_in.internal.AuthViewModel
import com.moshenskyi.sign_in.internal.helper.createSignInIntent
import com.moshenskyi.sign_in.internal.models.SignInParams
import com.moshenskyi.sign_in.internal.models.User

class AuthActivity : AppCompatActivity(R.layout.activity_auth) {
	private var signInButton: SignInButton? = null

	private var loginLauncher: ActivityResultLauncher<Intent>? = null

	private var signInIntent: Intent? = null

	private var binding: ActivityAuthBinding? = null

	private val viewModel by viewModels<AuthViewModel> { defaultViewModelProviderFactory }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityAuthBinding.inflate(layoutInflater)
		setContentView(binding?.root)

		viewModel.user.observe(this, { user ->
			updateUI(user)
		})

		initUi()

		signInIntent = createSignInIntent(this)

		loginLauncher = registerForActivityResult(StartActivityForResult()) { result ->
			if (result.resultCode == Activity.RESULT_OK) {
				viewModel.authenticate(SignInParams(this, result.data))
			}
		}
	}

	private fun initUi() {
		signInButton = binding?.signInGoogleButton
		signInButton?.setOnClickListener {
			loginLauncher?.launch(signInIntent)
		}
	}

	private fun updateUI(currentUser: User?) {
		if (currentUser != null) {
			val resultIntent = Intent()
				.putExtra(LOGGED_USER_NAME, currentUser.userName)
				.putExtra(LOGGED_USER_EMAIL, currentUser.email)

			setResult(Activity.RESULT_OK, resultIntent)
			finish()
		}
	}

	override fun onDestroy() {
		super.onDestroy()

		binding = null
	}

	companion object {
		const val LOGGED_USER_NAME = "logged_user_name"
		const val LOGGED_USER_EMAIL = "logged_user_email"
	}
}
