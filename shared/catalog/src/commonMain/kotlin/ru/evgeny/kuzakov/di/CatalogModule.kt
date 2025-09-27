package ru.evgeny.kuzakov.di

import org.koin.dsl.bind
import org.koin.dsl.module
import ru.evgeny.kuzakov.data.CatalogRepositoryImpl
import ru.evgeny.kuzakov.domain.CatalogRepository
import ru.evgeny.kuzakov.domain.useCase.GetProductsUseCase

val catalogModule = module {
	factory { GetProductsUseCase( get() ) }
	single { CatalogRepositoryImpl() }.bind<CatalogRepository>()
}


