package ru.evgeny.kuzakov.data

import ru.evgeny.kuzakov.data.entity.AuthResponseDto
import ru.evgeny.kuzakov.domain.User

fun AuthResponseDto.toDomain() = User(
	id = localId ?: "",
	email = email ?: "",
	token = idToken ?: "",
	refreshToken = refreshToken ?: ""
)