package ru.evgenykuzakov.async_image.compose

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.skia.Image

@Composable
fun AsyncImage(
	base64: String,
	modifier: Modifier = Modifier,
	contentScale: ContentScale = ContentScale.Crop
) {
	var state by remember { mutableStateOf<AsyncImageState>(AsyncImageState.Loading) }

	LaunchedEffect(base64) {
		state = try {
			val bytes = decodeBase64(base64)
			val bitmap = Image.makeFromEncoded(bytes).toComposeImageBitmap()
			AsyncImageState.Content(bitmap)
		} catch (e: Throwable) {
			e.printStackTrace()
			AsyncImageState.Error
		}
	}

	when (val s = state) {
		is AsyncImageState.Loading -> {
			Text("Загрузка", modifier = modifier)
		}
		is AsyncImageState.Content -> {
			Image(
				bitmap = s.bitmap,
				contentDescription = null,
				modifier = modifier,
				contentScale = contentScale
			)
		}
		is AsyncImageState.Error   -> {
			Text("Ошибка загрузки изображения", modifier = modifier)
		}
	}
}

@JsFun("(base64) => atob(base64)")
private external fun atobJs(base64: String): String

fun decodeBase64(dataUri: String): ByteArray {
	val base64 = dataUri.substringAfter("base64,")
	val binary = atobJs(base64)
	val len = binary.length
	val bytes = ByteArray(len)
	for (i in 0 until len) {
		bytes[i] = binary[i].toByte()
	}
	return bytes
}