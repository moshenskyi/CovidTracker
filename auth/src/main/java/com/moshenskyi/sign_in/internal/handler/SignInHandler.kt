package com.moshenskyi.sign_in.internal.handler

internal interface SignInHandler<T : SignInParams> {

	fun onSignedIn(params: T)

}

interface SignInParams
