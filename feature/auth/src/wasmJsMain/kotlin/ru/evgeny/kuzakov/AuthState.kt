package ru.evgeny.kuzakov

sealed interface AuthState {
	val email: String
	val password: String

	data class Idle(
		override val email: String = "",
		override val password: String = ""
	) : AuthState

	data class Loading(
		override val email: String,
		override val password: String
	) : AuthState

	data class Error(
		val message: String,
		override val email: String,
		override val password: String
	) : AuthState
}