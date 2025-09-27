package ru.evgeny.kuzakov.di

import org.koin.dsl.module
import ru.evgeny.kuzakov.CatalogViewModel

val featureCatalogModule = module {
	single {
		CatalogViewModel(get())
	}

	includes(catalogModule)
}