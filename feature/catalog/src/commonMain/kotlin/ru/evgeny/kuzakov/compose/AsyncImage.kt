package ru.evgeny.kuzakov.compose

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.decodeToImageBitmap
import kotlinx.browser.window
import kotlinx.coroutines.await
import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Int8Array
import org.khronos.webgl.get
import org.w3c.fetch.Response

@Composable
fun AsyncImage(
	url: String,
	alt: String = "",
	modifier: Modifier = Modifier,
	placeholder: String = "Загрузка...",
	errorText: String = "Ошибка загрузки"
) {
	var bitmap by remember { mutableStateOf<ImageBitmap?>(null) }

	LaunchedEffect(url) {
		val bytes = loadBytes(url)
		bitmap = bytes.decodeToImageBitmap()
	}

	bitmap?.let {
		Image(
			bitmap = it,
			contentDescription = null,
			modifier = modifier
		)
	}
}

suspend fun loadBytes(url: String): ByteArray {
	val response = window.fetch(url).await<Response>()
	val buffer: ArrayBuffer = response.arrayBuffer().await()
	val int8Array = Int8Array(buffer)
	return ByteArray(int8Array.length) { i -> int8Array[i] }
}