package com.moshenskyi.sign_in

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import timber.log.Timber

class SignInHelper {
    fun getSignInIntent(context: FragmentActivity): Intent {
        val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.debug_client_id))
            .requestEmail()
            .build()

        val signInClient = GoogleSignIn.getClient(context, options)
        return signInClient.signInIntent
    }

    private fun authenticate(
        activity: FragmentActivity,
        idToken: String,
        onSuccess: () -> Unit,
        onError: (exception: Exception?) -> Unit
    ) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)

        val authenticator = Firebase.auth
        authenticator.signInWithCredential(credential)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    onSuccess()
                } else {
                    // If sign in fails, display a message to the user.
                    onError(task.exception)
                }
            }
    }

    fun onSignedIn(
        activity: FragmentActivity,
        resultIntent: Intent?,
        onSuccess: () -> Unit,
        onError: (exception: Exception?) -> Unit
    ) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(resultIntent)
        try {
            // Google Sign In was successful, authenticate with Firebase
            val account = task.getResult(ApiException::class.java)!!
            Timber.d("firebaseAuthWithGoogle:" + account.id)
            authenticate(activity, account.idToken!!, onSuccess, onError)
        } catch (e: ApiException) {
            // Google Sign In failed, update UI appropriately
            Timber.w(e, "Google sign in failed")
        }
    }
}
