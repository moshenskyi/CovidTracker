package com.moshenskyi.sign_in.internal.handler.google

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.moshenskyi.sign_in.internal.handler.SignInHandler
import com.moshenskyi.sign_in.internal.handler.SignInParams
import timber.log.Timber

internal class GoogleSignInHandler : SignInHandler<GoogleSignInParams> {

	override fun onSignedIn(params: GoogleSignInParams) {
		val task = GoogleSignIn.getSignedInAccountFromIntent(params.resultIntent)
		try {
			// Google Sign In was successful, authenticate with Firebase
			val account = task.getResult(ApiException::class.java)!!
			Timber.d("firebaseAuthWithGoogle:" + account.id)
			authenticate(params, account.idToken!!)
		} catch (e: ApiException) {
			// Google Sign In failed, update UI appropriately
			Timber.w(e, "Google sign in failed")
		}
	}

	private fun authenticate(params: GoogleSignInParams, idToken: String) {
		val credential = GoogleAuthProvider.getCredential(idToken, null)

		Firebase.auth.signInWithCredential(credential)
			.addOnCompleteListener(params.context) { task ->
				if (task.isSuccessful) {
					// Sign in success, update UI with the signed-in user's information
					params.resultHandler.onSuccess()
				} else {
					// If sign in fails, display a message to the user.
					params.resultHandler.onError(task.exception)
				}
			}
	}
}

internal data class GoogleSignInParams(
	val context: FragmentActivity,
	val resultIntent: Intent?,
	val resultHandler: GoogleResultHandler
) : SignInParams
