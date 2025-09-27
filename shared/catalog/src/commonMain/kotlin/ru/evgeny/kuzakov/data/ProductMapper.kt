package ru.evgeny.kuzakov.data

import ru.evgeny.kuzakov.domain.Product

fun ProductDto.toDomain(id: String) = Product(
	id = id,
	title = title,
	description = description,
	hidden = hidden,
	price = price,
	discountPrice = discountPrice,
	imageUrl = imageUrl,
	rating = rating,
	specs = specs
)