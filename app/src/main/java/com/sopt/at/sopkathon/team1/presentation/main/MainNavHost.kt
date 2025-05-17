package com.sopt.at.sopkathon.team1.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sopt.at.sopkathon.team1.core.navigation.Route
import com.sopt.at.sopkathon.team1.presentation.home.HomeScreen
import com.sopt.at.sopkathon.team1.presentation.level.LevelScreen
import com.sopt.at.sopkathon.team1.presentation.productdetail.ProductDetailScreen
import com.sopt.at.sopkathon.team1.presentation.productlist.ProductListScreen

@Composable
fun MainNavHost(
    navigator: MainNavigator,
    modifier: Modifier = Modifier
) {
    val homeModifier = Modifier.padding(0.dp)
    val defaultModifier = modifier.systemBarsPadding()
    NavHost(
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
        navController = navigator.navController,
        startDestination = navigator.startDestination
    ) {
        composable<Route.Home>{
            HomeScreen(
                modifier = homeModifier,
                onNavigateToProductList = {
                    navigator.navigate(Route.ProductList)
                }
            )
        }
        composable<Route.ProductList>{
            ProductListScreen(
                modifier = defaultModifier,
            )
        }
        composable<Route.Level>{
            LevelScreen(
                modifier = defaultModifier
            )
        }
    }
}