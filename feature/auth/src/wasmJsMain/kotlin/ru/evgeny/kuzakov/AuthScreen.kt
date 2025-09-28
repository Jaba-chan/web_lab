package ru.evgeny.kuzakov

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AuthScreen(
	viewModel: AuthViewModel = remember { injectViewModel() },
	onSuccess: () -> Unit
) {
	val effects by viewModel.effects.collectAsState()

	LaunchedEffect(effects){
		when(effects){
			is AuthEffects.NavigateToCatalog -> {
				viewModel.resetEffect()
				onSuccess()
			}
			null                             -> Unit
		}
	}

	val state by viewModel.state.collectAsState()

	Column(
		modifier = Modifier
			.padding(16.dp)
			.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		OutlinedTextField(
			value = state.email,
			onValueChange = viewModel::handleEmailInput,
			label = { Text("Email") }
		)

		Spacer(Modifier.height(8.dp))

		OutlinedTextField(
			value = state.password,
			onValueChange = viewModel::handlePasswordInput,
			label = { Text("Пароль") }
		)

		Spacer(Modifier.height(16.dp))

		when (state) {
			is AuthState.Loading -> {
				CircularProgressIndicator()
			}
			is AuthState.Error -> {
				Text(
					text = (state as AuthState.Error).message,
					color = Color.Red
				)
			}
			else -> {}
		}

		Spacer(Modifier.height(16.dp))

		Row {
			Button(onClick = { viewModel.login(state.email, state.password) }) {
				Text("Войти")
			}
			Spacer(Modifier.width(8.dp))
			Button(onClick = { viewModel.register(state.email, state.password) }) {
				Text("Регистрация")
			}
		}
	}
}
