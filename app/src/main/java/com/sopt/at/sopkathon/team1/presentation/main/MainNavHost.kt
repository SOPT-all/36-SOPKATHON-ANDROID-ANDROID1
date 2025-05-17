package com.sopt.at.sopkathon.team1.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sopt.at.sopkathon.team1.core.navigation.MainTabRoute
import com.sopt.at.sopkathon.team1.core.navigation.Route
import com.sopt.at.sopkathon.team1.presentation.dummyscreens.home.HomeScreen
import com.sopt.at.sopkathon.team1.presentation.dummyscreens.mypage.MyPageScreen
import com.sopt.at.sopkathon.team1.presentation.dummyscreens.setting.SettingScreen

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
        //Bottom Navigation Screen
        composable<MainTabRoute.Home>{
            HomeScreen(
                modifier = modifier,
                onNavigateToMyPage = { userId ->
                    navigator.navigate(Route.MyPage(userId))
                    //bottomTab 으로 이동하는게 아니면 navigate함수 사용
                }
            )
        }
        composable<MainTabRoute.Setting>{
            SettingScreen(
                modifier = modifier
            )
        }
        //Other Screen
        composable<Route.MyPage>{
            MyPageScreen(
                modifier = modifier,
                onNavigateToSetting = {
                    navigator.navigateBottomTab(MainTab.SETTING)
                    //바텀 네비가 아닌 스크린에서 바텀 네비 스크린 이동 시 MainTab enum 클래스에 있는 탭을 인자로 navigateBottomTab호출
                }
            )
        }
    }
}