package ru.evgeny.kuzakov.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.evgeny.kuzakov.domain.Product

@Composable
fun ProductCard(product: Product) {
	Card(
		modifier = Modifier
			.padding(16.dp)
			.fillMaxWidth(),
		elevation = CardDefaults.cardElevation(8.dp)
	) {
		Column(modifier = Modifier.padding(16.dp)) {

			Spacer(Modifier.height(12.dp))

			Text(
				text = product.title,
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold,
				maxLines = 2,
				overflow = TextOverflow.Ellipsis
			)

			Spacer(Modifier.height(4.dp))

			Row(verticalAlignment = Alignment.CenterVertically) {
				if (product.discountPrice != null) {
					Text(
						text = "${product.price} ₽",
						color = Color.Gray,
						fontSize = 14.sp,
						textDecoration = TextDecoration.LineThrough
					)
					Spacer(Modifier.width(8.dp))
					Text(
						text = "${product.discountPrice} ₽",
						color = Color.Red,
						fontWeight = FontWeight.Bold,
						fontSize = 16.sp
					)
				} else {
					Text(
						text = "${product.price} ₽",
						fontWeight = FontWeight.Bold,
						fontSize = 16.sp
					)
				}

				Spacer(Modifier.weight(1f))

				product.rating?.let { rating ->
					Text("★ $rating", color = Color(0xFFFFC107), fontSize = 14.sp)
				}
			}

			Spacer(Modifier.height(8.dp))

			Text(
				text = product.description,
				fontSize = 14.sp,
				maxLines = 3,
				overflow = TextOverflow.Ellipsis
			)

			Spacer(Modifier.height(8.dp))

			HorizontalDivider()

			product.specs.forEach { (key, value) ->
				Column(modifier = Modifier.padding(vertical = 4.dp)) {
					Text(text = "$key:", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
					Text(text = value, fontSize = 14.sp)
					HorizontalDivider(modifier = Modifier.padding(top = 4.dp))
				}
			}
		}
	}
}
