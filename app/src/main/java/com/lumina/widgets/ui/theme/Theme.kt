package com.lumina.widgets.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LuminaDarkColorScheme = darkColorScheme(
    primary = Color(0xFF8B9CFF),
    onPrimary = Color.White,
    secondary = Color(0xFFB8C0FF),
    onSecondary = Color.White,
    background = Color(0xFF0F0F13),
    onBackground = Color.White,
    surface = Color(0xFF1C1C26),
    onSurface = Color.White,
    surfaceVariant = Color(0xFF2A2A36),
    onSurfaceVariant = Color.White.copy(alpha = 0.7f)
)

@Composable
fun LuminaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LuminaDarkColorScheme,
        content = content
    )
}

// Liquid Glass colors
object Glass {
    val Border = Color.White.copy(alpha = 0.15f)
    val Fill = Color.White.copy(alpha = 0.08f)
    val FillStrong = Color.White.copy(alpha = 0.12f)
    val Highlight = Color.White.copy(alpha = 0.25f)
    val TextPrimary = Color.White
    val TextSecondary = Color.White.copy(alpha = 0.65f)
    val Accent = Color(0xFF8B9CFF)
}
