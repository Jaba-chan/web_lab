package ru.evgeny.kuzakov.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = White,
    onPrimary = Black,
    background = White,
    surface = White,
    surfaceContainer = White,
)

private val DarkColors = darkColorScheme(
    primary = White,
    onPrimary = Black,
    background = White,
    surface = White,
    surfaceContainer = White,
)

@Composable
fun DnsTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (useDarkTheme) DarkColors else LightColors,
        typography = Typography,
        content = content
    )
}