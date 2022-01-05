package com.moshenskyi.sign_in.sign_in_handler

interface SignInHandler<T : SignInParams> {

	fun onSignedIn(params: T)

}

interface SignInParams
