package com.moshenskyi.core

abstract class NetworkError(
	message: String? = null,
	cause: Throwable? = null,
) : Exception(message, cause)

class ConnectionError(
	message: String? = "An error occurred with connection to our servers",
	cause: Throwable? = null,
) : NetworkError(message, cause)

class ServerError(
	message: String? = "An error occurred on our side",
	cause: Throwable? = null,
) : NetworkError(message, cause)
