package com.sopt.at.sopkathon.team1.core.extension

import java.text.DecimalFormat

fun Int.toDecimalFormat(): String {
    val decimalFormat = DecimalFormat("#,###")
    return decimalFormat.format(this)
}