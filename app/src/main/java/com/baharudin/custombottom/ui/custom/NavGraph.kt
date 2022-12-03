package com.baharudin.custombottom.ui.custom

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.baharudin.custombottom.ui.screen.HomeScreen
import com.baharudin.custombottom.ui.screen.ProfileScreen
import com.baharudin.custombottom.ui.screen.SearchScreen
import com.baharudin.custombottom.ui.screen.SettingScreen

@Composable
fun Navigation(navController : NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.id
    ) {
        composable(Screen.Home.id) {
            HomeScreen()
        }
        composable(Screen.Search.id) {
            SearchScreen()
        }
        composable(Screen.Setting.id) {
            SettingScreen()
        }
        composable(Screen.Profile.id) {
            ProfileScreen()
        }
    }
}