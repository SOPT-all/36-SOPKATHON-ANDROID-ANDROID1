package com.sopt.at.sopkathon.team1.core.navigation

import kotlinx.serialization.Serializable
sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data object ProductList : Route

    @Serializable
    data object Level : Route
}