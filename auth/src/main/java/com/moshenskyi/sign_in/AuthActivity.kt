package com.moshenskyi.sign_in

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.SignInButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.moshenskyi.sign_in.databinding.ActivityAuthBinding
import timber.log.Timber

class AuthActivity : AppCompatActivity(R.layout.activity_auth) {
	private var signInButton: SignInButton? = null
	private lateinit var auth: FirebaseAuth

	private var loginLauncher: ActivityResultLauncher<Intent>? = null

	private var signInIntent: Intent? = null

	private val signInHelper = SignInHelper()

	private var binding: ActivityAuthBinding? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityAuthBinding.inflate(layoutInflater)
		setContentView(binding?.root)

		auth = Firebase.auth

		initUi()

		signInIntent = signInHelper.getSignInIntent(this)

		loginLauncher = registerForActivityResult(StartActivityForResult()) { result ->
			if (result.resultCode == Activity.RESULT_OK) {
				authenticate(result)
			}
		}
	}

	private fun authenticate(result: ActivityResult) {
		signInHelper.onSignedIn(this, result.data, {
			Timber.d("signInWithCredential:success")
			val user = auth.currentUser
			updateUI(user)
		}, { exception ->
			Timber.w(exception, "signInWithCredential:failure")
			updateUI(null)
		})
	}

	private fun initUi() {
		signInButton = binding?.signInGoogleButton
		signInButton?.setOnClickListener {
			loginLauncher?.launch(signInIntent)
		}
	}

	override fun onStart() {
		super.onStart()
		// Check if user is signed in (non-null) and update UI accordingly.
		val currentUser = auth.currentUser
		updateUI(currentUser)
	}

	private fun updateUI(currentUser: FirebaseUser?) {
		if (currentUser != null) {
			val resultIntent = Intent()
				.putExtra(LOGGED_USER_NAME, currentUser.displayName)
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
