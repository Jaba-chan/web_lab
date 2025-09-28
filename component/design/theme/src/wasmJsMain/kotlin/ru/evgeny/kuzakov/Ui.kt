package ru.evgeny.kuzakov

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun OutlineTextInput(
	value: String,
	label: String,
	onValueChange: (String) -> Unit
){
	OutlinedTextField(
		value = value,
		onValueChange = onValueChange,
		label = { Text(label) },
		colors = OutlinedTextFieldDefaults.colors(
			focusedContainerColor = MaterialTheme.colorScheme.primary
		)
	)
}