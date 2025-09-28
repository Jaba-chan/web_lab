package ru.evgeny.kuzakov.di

import org.koin.dsl.module
import ru.evgeny.kuzakov.AuthViewModel

val featureAuthModule = module {
	single {
		AuthViewModel(get(), get())
	}

	includes(authModule)
}