package ru.evgeny.kuzakov.data.mappers

import ru.evgeny.kuzakov.data.entity.UserDto
import ru.evgeny.kuzakov.domain.User

fun UserDto.toDomain() = User(
	email = email,
	id = id,
	token = token,
	refreshToken = refreshToken
)