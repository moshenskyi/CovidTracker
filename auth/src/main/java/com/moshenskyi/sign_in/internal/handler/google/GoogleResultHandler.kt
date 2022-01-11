package com.moshenskyi.sign_in.internal.handler.google

internal data class GoogleResultHandler(
	val onSuccess: () -> Unit,
	val onError: (exception: Exception?) -> Unit
)
