package com.sopt.at.sopkathon.team1.core.designsystem.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

@Immutable
data class SopkatonColors(
    val Purple80: Color,
    val PurpleGrey80: Color,
    val Pink80: Color,

    val Purple40: Color,
    val PurpleGrey40: Color,
    val Pink40: Color,
)

val defaultSopkatonColors = SopkatonColors(
    Purple80 = Purple80,
    PurpleGrey80 = PurpleGrey80,
    Pink80 = Pink80,

    Purple40 = Purple40,
    PurpleGrey40 = PurpleGrey40,
    Pink40 = Pink40,
)

val LocalSopkatonColorsProvider = staticCompositionLocalOf { defaultSopkatonColors }