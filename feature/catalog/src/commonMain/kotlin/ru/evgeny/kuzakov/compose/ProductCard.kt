package ru.evgeny.kuzakov.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.evgeny.kuzakov.domain.Product
import ru.evgenykuzakov.async_image.compose.AsyncImage
import ru.evgenykuzakov.async_image.compose.mockImg

@Composable
fun ProductCard(product: Product) {
	Card(
		modifier = Modifier
			.padding(16.dp)
			.fillMaxWidth()
			.height(250.dp),
		colors = CardDefaults.cardColors(
			containerColor = MaterialTheme.colorScheme.surface
		),
		elevation = CardDefaults.cardElevation(8.dp)
	) {
		Row(
			modifier = Modifier
				.padding(12.dp)
				.fillMaxWidth()
		) {
			AsyncImage(
				base64 = mockImg(),
				modifier = Modifier
					.weight(1f)
					.height(200.dp)
				,
				contentScale = ContentScale.Fit
			)

			Spacer(Modifier.width(12.dp))

			Column(
				modifier = Modifier.weight(2f)
			) {
				Text(
					text = product.description,
					fontSize = 14.sp,
					maxLines = 4,
					overflow = TextOverflow.Ellipsis
				)

				Spacer(Modifier.height(8.dp))

				var index = 0
				product.specs.forEach { (key, value) ->
					index++
					Column(modifier = Modifier.padding(vertical = 2.dp)) {
						Text(
							text = "$key:",
							fontWeight = FontWeight.SemiBold,
							fontSize = 13.sp
						)
						Text(text = value, fontSize = 13.sp)
						if (index < product.specs.size)
						HorizontalDivider()
					}
				}
			}

			Spacer(Modifier.width(12.dp))

			Column(
				modifier = Modifier
					.fillMaxHeight()
					.background(Color.White)
					.weight(1f),
				horizontalAlignment = Alignment.End
			) {
				Text(
					text = product.title,
					fontSize = 16.sp,
					fontWeight = FontWeight.Bold,
					maxLines = 2,
					overflow = TextOverflow.Ellipsis
				)

				Spacer(Modifier.height(6.dp))

				Row(verticalAlignment = Alignment.CenterVertically) {
					if (product.discountPrice != null) {
						Text(
							text = "${product.price} ₽",
							color = Color.Gray,
							fontSize = 12.sp,
							textDecoration = TextDecoration.LineThrough
						)
						Spacer(Modifier.width(6.dp))
						Text(
							text = "${product.discountPrice} ₽",
							color = Color.Red,
							fontWeight = FontWeight.Bold,
							fontSize = 14.sp
						)
					} else {
						Text(
							text = "${product.price} ₽",
							fontWeight = FontWeight.Bold,
							fontSize = 14.sp
						)
					}
				}

				Spacer(Modifier.weight(1f))

				product.rating?.let { rating ->
					Text(
						"★ $rating",
						color = Color(0xFFFFC107),
						fontSize = 14.sp
					)
				}
			}
		}
	}
}