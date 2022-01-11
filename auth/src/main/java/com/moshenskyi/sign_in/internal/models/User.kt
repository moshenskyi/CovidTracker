package com.moshenskyi.sign_in.internal.models

import com.google.firebase.auth.FirebaseUser

internal data class User(val userName: String?, val email: String?) {

	companion object {
		fun fromFirebaseUser(user: FirebaseUser?): User? {
			if (user == null) return null

			return User(user.displayName, user.email)
		}
	}
}
