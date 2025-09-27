package ru.evgeny.kuzakov.compose

sealed interface AsyncImageState {
	data object Content: AsyncImageState
	data object Error: AsyncImageState
	data object Loading: AsyncImageState
}