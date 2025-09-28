package di

import org.koin.dsl.module
import ru.evgeny.kuzakov.di.featureAuthModule
import ru.evgeny.kuzakov.di.featureCatalogModule

val appModule = module {
	includes(featureCatalogModule)
	includes(featureAuthModule)
}