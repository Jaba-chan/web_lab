package ru.evgeny.kuzakov.di

import org.koin.dsl.module

val appModule = module {
	includes(featureCatalogModule)
}