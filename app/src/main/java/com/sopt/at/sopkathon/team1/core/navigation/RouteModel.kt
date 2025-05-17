package com.sopt.at.sopkathon.team1.core.navigation

import kotlinx.serialization.Serializable
sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data class ProductList(
        val category: String
    ) : Route

    @Serializable
    data class ProductDetail(
        val productId: Long
    ) : Route

    @Serializable
    data object Level : Route
}