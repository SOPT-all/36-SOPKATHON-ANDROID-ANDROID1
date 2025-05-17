package com.sopt.at.sopkathon.team1.core.designsystem.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import java.lang.Error

val White = Color(0xFFFFFFFF)
val GrayBackground = Color(0xFFFBFDFB)
val Gray100 = Color(0xFFE9EAEA)
val Gray200 = Color(0xFFD4D6D4)
val Gray300 = Color(0xFFBEC1BF)
val Gray400 = Color(0xFFA9ACA9)
val Gray500 = Color(0xFF939894)
val Gray600 = Color(0xFF767976)
val Gray700 = Color(0xFF585B59)
val Gray800 = Color(0xFF3B3D3B)
val Gray900 = Color(0xFF1D1E1E)

val Primary100 = Color(0xFFBCEDE7)
val Primary200 = Color(0xFFB9DDCF)
val Primary300 = Color(0xFF95CAB6)
val Primary400 = Color(0xFF72B89E)
val Primary500 = Color(0xFF4FA686)
val Primary600 = Color(0xFF3F856B)
val Primary700 = Color(0xFF2F6450)
val Primary800 = Color(0xFF204236)
val Primary900 = Color(0xFF10211B)

val Secondary100 = Color(0xFFFCF4F3)
val Secondary200 = Color(0xFFF9E9E7)
val Secondary300 = Color(0xFFF7DEDC)
val Secondary400 = Color(0xFFF4D3D0)
val Secondary500 = Color(0xFFF1C8C4)
val Secondary600 = Color(0xFFC1A09D)
val Secondary700 = Color(0xFF917876)
val Secondary800 = Color(0xFF60504E)
val Secondary900 = Color(0xFF302827)

val ErrorColor = Color(0xFFFF4E6F)
val ErrorSurface = Color(0xFFFAE9EC)


@Immutable
data class SopkatonColors(
    val White: Color,
    val GrayBackground: Color,
    val Gray100: Color,
    val Gray200: Color,
    val Gray300: Color,
    val Gray400: Color,
    val Gray500: Color,
    val Gray600: Color,
    val Gray700: Color,
    val Gray800: Color,
    val Gray900: Color,

    val Primary100: Color,
    val Primary200: Color,
    val Primary300: Color,
    val Primary400: Color,
    val Primary500: Color,
    val Primary600: Color,
    val Primary700: Color,
    val Primary800: Color,
    val Primary900: Color,

    val Secondary100: Color,
    val Secondary200: Color,
    val Secondary300: Color,
    val Secondary400: Color,
    val Secondary500: Color,
    val Secondary600: Color,
    val Secondary700: Color,
    val Secondary800: Color,
    val Secondary900: Color,

    val ErrorColor: Color,
    val ErrorSurface: Color
)

val defaultSopkatonColors = SopkatonColors(
    White = White,
    GrayBackground = GrayBackground,
    Gray100 = Gray100,
    Gray200 = Gray200,
    Gray300 = Gray300,
    Gray400 = Gray400,
    Gray500 = Gray500,
    Gray600 = Gray600,
    Gray700 = Gray700,
    Gray800 = Gray800,
    Gray900 = Gray900,

    Primary100 = Primary100,
    Primary200 = Primary200,
    Primary300 = Primary300,
    Primary400 = Primary400,
    Primary500 = Primary500,
    Primary600 = Primary600,
    Primary700 = Primary700,
    Primary800 = Primary800,
    Primary900 = Primary900,

    Secondary100 = Secondary100,
    Secondary200 = Secondary200,
    Secondary300 = Secondary300,
    Secondary400 = Secondary400,
    Secondary500 = Secondary500,
    Secondary600 = Secondary600,
    Secondary700 = Secondary700,
    Secondary800 = Secondary800,
    Secondary900 = Secondary900,

    ErrorColor = ErrorColor,
    ErrorSurface = ErrorSurface
)

val LocalSopkatonColorsProvider = staticCompositionLocalOf { defaultSopkatonColors }