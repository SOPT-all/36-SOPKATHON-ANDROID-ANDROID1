package com.sopt.at.sopkathon.team1.presentation.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.sopt.at.sopkathon.team1.R
import com.sopt.at.sopkathon.team1.core.navigation.MainTabRoute
import com.sopt.at.sopkathon.team1.core.navigation.Route

enum class MainTab(
    @DrawableRes val defaultIconResId: Int,
    @DrawableRes val selectIconResId: Int,
    @StringRes val descriptionResId: Int,
    val route: MainTabRoute,
) {
    HOME(
        defaultIconResId = R.drawable.ic_dummy_home_default,
        selectIconResId =  R.drawable.ic_dummy_home_select,
        descriptionResId = R.string.bottom_navigation_bar_item_home,
        route = MainTabRoute.Home,
    ),
    SETTING(
        defaultIconResId = R.drawable.ic_dummy_setting,
        selectIconResId =  R.drawable.ic_dummy_setting,
        descriptionResId = R.string.bottom_navigation_bar_item_setting,
        MainTabRoute.Setting,
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}