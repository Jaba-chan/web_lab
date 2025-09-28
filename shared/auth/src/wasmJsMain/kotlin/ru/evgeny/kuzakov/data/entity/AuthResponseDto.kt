package ru.evgeny.kuzakov.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponseDto(
	val idToken: String? = null,
	val email: String? = null,
	val refreshToken: String? = null,
	val localId: String? = null
)