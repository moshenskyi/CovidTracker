package com.moshenskyi.sign_in.internal.helper

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.moshenskyi.sign_in.R

internal fun createSignInIntent(context: FragmentActivity): Intent {
	val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
		.requestIdToken(context.getString(R.string.debug_client_id))
		.requestEmail()
		.build()

	return GoogleSignIn.getClient(context, options).signInIntent
}
