package ru.evgeny.kuzakov.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import ru.evgeny.kuzakov.data.entity.AuthRequestDto
import ru.evgeny.kuzakov.data.entity.AuthResponseDto
import ru.evgeny.kuzakov.domain.AuthRepository
import ru.evgeny.kuzakov.domain.User

class AuthRepositoryImpl(
	private val apiKey: String = "AIzaSyAqLzNjPd7TNEBoGQ-BHguj7UJCvkwiaQc",
	private val client: HttpClient = HttpClient {
		install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
	}
) : AuthRepository {

	override suspend fun register(email: String, password: String): User {
		val dto: AuthResponseDto = client.post(
			"https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=$apiKey"
		) {
			contentType(ContentType.Application.Json)
			setBody(AuthRequestDto(email, password))
		}.body()
		return dto.toDomain()
	}

	override suspend fun login(email: String, password: String): User {
		val dto: AuthResponseDto = client.post(
			"https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=$apiKey"
		) {
			contentType(ContentType.Application.Json)
			setBody(AuthRequestDto(email, password))
		}.body()
		return dto.toDomain()
	}
}