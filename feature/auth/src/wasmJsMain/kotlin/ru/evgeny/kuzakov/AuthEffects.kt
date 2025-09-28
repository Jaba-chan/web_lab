package ru.evgeny.kuzakov

import ru.evgeny.kuzakov.domain.User

sealed interface AuthEffects {
	data class NavigateToCatalog(val user: User) : AuthEffects
}