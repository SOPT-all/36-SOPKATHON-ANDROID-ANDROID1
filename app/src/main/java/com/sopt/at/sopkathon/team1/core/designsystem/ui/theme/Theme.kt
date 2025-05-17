package com.sopt.at.sopkathon.team1.core.designsystem.ui.theme

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun ProvideColorsAndTypography(
    colors: SopkatonColors,
    typography: SopkatonTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalSopkatonColorsProvider provides colors,
        LocalTypographyProvider provides typography,
        content = content
    )
}

@Composable
fun SopkatonTheme(
    content: @Composable () -> Unit
) {
    ProvideColorsAndTypography(
        colors = defaultSopkatonColors,
        typography = defaultSopkatonTypography
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = false
                }
            }
        }
        MaterialTheme(
            content = content
        )
    }
}