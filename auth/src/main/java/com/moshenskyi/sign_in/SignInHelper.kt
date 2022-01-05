package com.moshenskyi.sign_in

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.moshenskyi.sign_in.sign_in_handler.SignInHandler
import com.moshenskyi.sign_in.sign_in_handler.google.GoogleResultHandler
import com.moshenskyi.sign_in.sign_in_handler.google.GoogleSignInHandler
import com.moshenskyi.sign_in.sign_in_handler.google.GoogleSignInParams

class SignInHelper {
	private val signInHandler: SignInHandler<GoogleSignInParams> by lazy { GoogleSignInHandler() }

	fun getSignInIntent(context: FragmentActivity): Intent {
		val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
			.requestIdToken(context.getString(R.string.debug_client_id))
			.requestEmail()
			.build()

		return GoogleSignIn.getClient(context, options).signInIntent
	}

	fun onSignedIn(
		activity: FragmentActivity,
		resultIntent: Intent?,
		onSuccess: () -> Unit,
		onError: (exception: Exception?) -> Unit,
	) {
		signInHandler.onSignedIn(
			GoogleSignInParams(
				activity,
				resultIntent,
				GoogleResultHandler(
					onSuccess, onError
				)
			)
		)
	}
}
