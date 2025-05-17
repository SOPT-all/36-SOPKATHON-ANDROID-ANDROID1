package com.sopt.at.sopkathon.team1.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                modifier = modifier,
                onNavigateToProductList = {
                    navigator.navigate(Route.ProductList)
                }
            )
        }
        composable<Route.ProductList>{
            ProductListScreen(
                modifier = modifier,
                onNavigateToProductDetail = {
                    navigator.navigate(Route.ProductDetail)
                }
            )
        }
        composable<Route.ProductDetail>{
            ProductDetailScreen(
                modifier = modifier,
                onNavigateToLevel = {
                    navigator.navigate(Route.Level)
                }
            )
        }
        composable<Route.Level>{
            LevelScreen(
                modifier = modifier
            )
        }
    }
}