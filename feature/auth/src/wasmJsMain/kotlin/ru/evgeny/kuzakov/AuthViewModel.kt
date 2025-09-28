package ru.evgeny.kuzakov

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.evgeny.kuzakov.domain.useCases.LoginUserUseCase
import ru.evgeny.kuzakov.domain.useCases.RegisterUserUseCase

class AuthViewModel(
	private val registerUser: RegisterUserUseCase,
	private val loginUser: LoginUserUseCase
) : ViewModel() {

	private val _state = MutableStateFlow<AuthState>(AuthState.Idle())
	val state: StateFlow<AuthState> = _state

	private val _effects = MutableStateFlow<AuthEffects?>(null)
	val effects: StateFlow<AuthEffects?> = _effects

	fun resetEffect(){
		_effects.value = null
	}

	fun handlePasswordInput(text: String) {
		_state.update {
			when (it) {
				is AuthState.Idle -> it.copy(password = text)
				is AuthState.Loading -> it.copy(password = text)
				is AuthState.Error -> it.copy(password = text)
			}
		}
	}

	fun handleEmailInput(text: String) {
		_state.update {
			when (it) {
				is AuthState.Idle -> it.copy(email = text)
				is AuthState.Loading -> it.copy(email = text)
				is AuthState.Error -> it.copy(email = text)
			}
		}
	}


	fun login(email: String, password: String) {
		_state.value = AuthState.Loading(_state.value.email, _state.value.password)
		viewModelScope.launch {
			try {
				val user = loginUser(email, password)
				_effects.value = AuthEffects.NavigateToCatalog(user)
			} catch (e: Exception) {
				_state.value = AuthState.Error(e.message ?: "Ошибка входа", _state.value.email, _state.value.password)
			}
		}
	}

	fun register(email: String, password: String) {
		_state.value = AuthState.Loading(_state.value.email, _state.value.password)
		viewModelScope.launch {
			try {
				val user = registerUser(email, password)
				_effects.value = AuthEffects.NavigateToCatalog(user)
			} catch (e: Exception) {
				_state.value = AuthState.Error(e.message ?: "Ошибка регистрации", _state.value.email, _state.value.password)
			}
		}
	}
}