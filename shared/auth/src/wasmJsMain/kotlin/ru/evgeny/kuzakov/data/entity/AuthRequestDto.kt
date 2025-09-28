package ru.evgeny.kuzakov.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class AuthRequestDto(
	val email: String,
	val password: String,
	val returnSecureToken: Boolean = true
)