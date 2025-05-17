package com.sopt.at.sopkathon.team1.core.designsystem.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sopt.at.sopkathon.team1.R

val Suit = FontFamily(
    Font(R.font.suit_regular, FontWeight.Normal),
    Font(R.font.suit_semibold, FontWeight.SemiBold),
    Font(R.font.suit_extrabold, FontWeight.ExtraBold)
)

@Immutable
data class SopkatonTypography(
    val body_r_24: TextStyle,
    val body_r_20: TextStyle,
    val body_r_18: TextStyle,
    val body_r_16: TextStyle,
    val body_r_14: TextStyle,
    val body_r_12: TextStyle,

    val title_sb_32: TextStyle,
    val title_sb_28: TextStyle,
    val title_sb_24: TextStyle,
    val title_sb_20: TextStyle,
    val title_sb_18: TextStyle,
    val title_sb_16: TextStyle,
    val title_sb_14: TextStyle,

    val head_eb_32: TextStyle,
    val head_eb_28: TextStyle,
    val head_eb_24: TextStyle,
    val head_eb_20: TextStyle,
    val head_eb_18: TextStyle,
    val head_eb_16: TextStyle,
)

val defaultSopkatonTypography = SopkatonTypography(
    body_r_24 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    body_r_20 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    body_r_18 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    body_r_16 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body_r_14 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body_r_12 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),


    title_sb_32 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp
    ),
    title_sb_28 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp
    ),
    title_sb_24 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    title_sb_20 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    title_sb_18 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    title_sb_16 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    title_sb_14 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),

    head_eb_32 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp
    ),
    head_eb_28 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp
    ),
    head_eb_24 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp
    ),
    head_eb_20 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    ),
    head_eb_18 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 18.sp
    ),
    head_eb_16 = TextStyle(
        fontFamily = Suit,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp
    )
)

val LocalTypographyProvider = staticCompositionLocalOf { defaultSopkatonTypography }