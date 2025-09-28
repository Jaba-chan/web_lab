package ru.evgeny.kuzakov.domain.useCases

import ru.evgeny.kuzakov.domain.AuthRepository
import ru.evgeny.kuzakov.domain.User

class RegisterUserUseCase(
	private val repo: AuthRepository
) {
	suspend operator fun invoke(email: String, password: String) =
		repo.register(email, password)
}
