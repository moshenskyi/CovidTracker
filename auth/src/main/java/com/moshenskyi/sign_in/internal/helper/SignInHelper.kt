package com.moshenskyi.sign_in.internal.helper

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.moshenskyi.sign_in.internal.handler.SignInHandler
import com.moshenskyi.sign_in.internal.handler.google.GoogleResultHandler
import com.moshenskyi.sign_in.internal.handler.google.GoogleSignInHandler
import com.moshenskyi.sign_in.internal.handler.google.GoogleSignInParams

internal class SignInHelper {
	private val signInHandler: SignInHandler<GoogleSignInParams> by lazy { GoogleSignInHandler() }

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
