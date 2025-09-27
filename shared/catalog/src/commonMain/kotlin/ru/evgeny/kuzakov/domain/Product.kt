package ru.evgeny.kuzakov.domain

data class Product(
	val id: String,
	val title: String,
	val price: Double,
	val discountPrice: Double?,
	val imageUrl: String,
	val description: String,
	val rating: Double?,
	val specs: Map<String, String>,
	val hidden: Boolean = false
)