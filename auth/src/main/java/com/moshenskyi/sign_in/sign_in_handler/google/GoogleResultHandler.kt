package com.moshenskyi.sign_in.sign_in_handler.google

data class GoogleResultHandler(
	val onSuccess: () -> Unit,
	val onError: (exception: Exception?) -> Unit
)
