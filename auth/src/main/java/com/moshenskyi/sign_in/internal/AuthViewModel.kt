package com.moshenskyi.sign_in.internal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.moshenskyi.sign_in.internal.helper.SignInHelper
import com.moshenskyi.sign_in.internal.models.SignInParams
import com.moshenskyi.sign_in.internal.models.User
import timber.log.Timber

internal class AuthViewModel: ViewModel() {
	private val auth: FirebaseAuth = Firebase.auth
	private val signInHelper = SignInHelper()

	private val _user: MutableLiveData<User?> = MutableLiveData()
	val user: LiveData<User?>

	init {
		_user.value = User.fromFirebaseUser(auth.currentUser)
		user = _user
	}

	fun authenticate(params: SignInParams) {
		signInHelper.onSignedIn(
			params.context,
			params.data,
			{
				Timber.d("signInWithCredential:success")
				_user.value = User.fromFirebaseUser(auth.currentUser)
			}, { exception ->
				Timber.w(exception, "signInWithCredential:failure")
				_user.value = null
			}
		)
	}
}
