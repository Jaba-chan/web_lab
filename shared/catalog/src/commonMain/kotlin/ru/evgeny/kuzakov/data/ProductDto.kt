package ru.evgeny.kuzakov.data

import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
	val title: String,
	val price: Double,
	val discountPrice: Double? = null,
	val imageUrl: String,
	val description: String,
	val rating: Double?,
	val specs: Map<String, String>,
	val hidden: Boolean = false
)