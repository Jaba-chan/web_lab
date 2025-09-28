package ru.evgeny.kuzakov.domain

data class AuthRequest(
	val email: String,
	val password: String,
)