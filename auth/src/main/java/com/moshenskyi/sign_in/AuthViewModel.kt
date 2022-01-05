package com.moshenskyi.sign_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthViewModel: ViewModel() {
	private var auth: FirebaseAuth = Firebase.auth

	val user: LiveData<FirebaseUser?> = liveData { emit(auth.currentUser) }
}
