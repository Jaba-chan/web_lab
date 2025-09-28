package ru.evgeny.kuzakov.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.evgeny.kuzakov.CatalogViewModel
import ru.evgeny.kuzakov.injectViewModel

@Composable
fun CatalogScreen() {
	val viewModel = remember { injectViewModel<CatalogViewModel>() }

	LaunchedEffect(Unit){
		viewModel.getCatalog()
	}

	val state by viewModel.uiState.collectAsState()
	LazyColumn(
		modifier = Modifier
			.fillMaxSize()
			.padding(horizontal = 52.dp)
	) {
		items(state) { product ->
			ProductCard(product)
		}
	}
}