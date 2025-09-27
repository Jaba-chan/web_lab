package ru.evgenykuzakov.async_image.compose

import androidx.compose.ui.graphics.ImageBitmap

sealed interface AsyncImageState {
	data object Error: AsyncImageState
	data class Content(val bitmap: ImageBitmap) : AsyncImageState
	data object Loading: AsyncImageState
}