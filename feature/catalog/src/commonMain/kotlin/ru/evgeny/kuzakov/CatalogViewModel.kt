package ru.evgeny.kuzakov

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.evgeny.kuzakov.data.CatalogRepositoryImpl
import ru.evgeny.kuzakov.domain.CatalogRepository
import ru.evgeny.kuzakov.domain.Product
import ru.evgeny.kuzakov.domain.useCase.GetProductsUseCase

class CatalogViewModel(
	private val getProductsUseCase: GetProductsUseCase
): ViewModel() {

	private val _uiState = MutableStateFlow(emptyList<Product>())
	val uiState: StateFlow<List<Product>> = _uiState

	suspend fun getCatalog(){
		_uiState.value = getProductsUseCase(withHidden = true)
	}

}