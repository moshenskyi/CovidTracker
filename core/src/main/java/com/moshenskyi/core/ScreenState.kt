package com.moshenskyi.core

sealed class ScreenState<T> {
	data class Success<T>(val result: T): ScreenState<T>()
	data class Failure<T>(val message: String?): ScreenState<T>()
	class Loading<T> : ScreenState<T>()
}
