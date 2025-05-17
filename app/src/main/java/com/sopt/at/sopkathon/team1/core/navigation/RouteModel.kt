package com.sopt.at.sopkathon.team1.core.navigation

import kotlinx.serialization.Serializable
sealed interface Route {
    @Serializable
    data class MyPage(
        val userId: Long,
    ) : Route
}

sealed interface MainTabRoute : Route {
    @Serializable
    data object Home : MainTabRoute
    @Serializable
    data object Setting : MainTabRoute
}