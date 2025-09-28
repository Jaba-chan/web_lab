package ru.evgeny.kuzakov.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
	val id: String,
	val email: String,
	val token: String,
	val refreshToken: String
)