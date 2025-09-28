package ru.evgeny.kuzakov.di

import org.koin.dsl.module
import ru.evgeny.kuzakov.data.AuthRepositoryImpl
import ru.evgeny.kuzakov.domain.AuthRepository
import ru.evgeny.kuzakov.domain.useCases.LoginUserUseCase
import ru.evgeny.kuzakov.domain.useCases.RegisterUserUseCase

val authModule = module {
	single<AuthRepository> { AuthRepositoryImpl() }
	factory { RegisterUserUseCase(get()) }
	factory { LoginUserUseCase(get()) }
}