package com.example.daily.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.graphics.Color

private val DailyLightColorScheme = lightColorScheme(
    primary = DailyPrimary,
    onPrimary = Color.White,

    primaryContainer = DailySoftGreen,
    onPrimaryContainer = DailyPrimaryDark,

    secondary = DailyPrimaryDark,
    onSecondary = Color.White,

    background = DailyBackground,
    onBackground = DailyTextPrimary,

    surface = DailySurface,
    onSurface = DailyTextPrimary,

    surfaceVariant = DailySurfaceContainer,
    onSurfaceVariant = DailyTextSecondary,

    outline = DailyOutline,

    error = DailyError,
    onError = DailyOnError
)

private val DailyDarkColorScheme = darkColorScheme(
    primary = DailyPrimary,
    onPrimary = Color.White,

    primaryContainer = DailyPrimaryDark,
    onPrimaryContainer = DailySoftGreen,

    secondary = DailySoftGreen,
    onSecondary = DailyPrimaryDark,

    background = Color(0xFF101510),
    onBackground = Color(0xFFE8F0E7),

    surface = Color(0xFF151A16),
    onSurface = Color(0xFFE8F0E7),

    surfaceVariant = Color(0xFF3D443E),
    onSurfaceVariant = Color(0xFFC1CAC0),

    outline = DailyOutline,

    error = DailyError,
    onError = Color.White
)

@Composable
fun DailyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current

            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> DailyDarkColorScheme
        else -> DailyLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = DailyTypography,
        content = content
    )
}