package ru.evgeny.kuzakov.domain.useCases

import ru.evgeny.kuzakov.domain.AuthRepository
import ru.evgeny.kuzakov.domain.User

class LoginUserUseCase(
	private val repo: AuthRepository
) {
	suspend operator fun invoke(email: String, password: String): User =
		repo.login(email, password)
}