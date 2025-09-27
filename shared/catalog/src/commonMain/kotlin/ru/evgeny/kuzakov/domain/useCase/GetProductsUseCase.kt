package ru.evgeny.kuzakov.domain.useCase

import ru.evgeny.kuzakov.domain.CatalogRepository
import ru.evgeny.kuzakov.domain.Product

class GetProductsUseCase(
	private val repository: CatalogRepository
) {
	suspend operator fun invoke(withHidden: Boolean): List<Product> = repository.getAll(withHidden)
}