package ru.evgeny.kuzakov.domain

data class User(
	val id: String,
	val email: String,
	val token: String,
	val refreshToken: String
)