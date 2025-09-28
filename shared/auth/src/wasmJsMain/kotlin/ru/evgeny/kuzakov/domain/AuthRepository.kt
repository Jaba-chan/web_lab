package ru.evgeny.kuzakov.domain

interface AuthRepository {
	suspend fun register(email: String, password: String): User
	suspend fun login(email: String, password: String): User
}