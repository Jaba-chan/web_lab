package ru.evgeny.kuzakov.domain

interface CatalogRepository {

	suspend fun getAll(withHidden: Boolean = false): List<Product>

	suspend fun get(id: String): Product
}