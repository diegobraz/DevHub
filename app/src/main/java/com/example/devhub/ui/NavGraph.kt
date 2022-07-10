package com.example.devhub.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.devhub.ui.componentes.HomeScreen
import com.example.devhub.ui.componentes.LoginScreem

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    mainViewModel: MainViewModel
) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(
            route = Screen.Login.route
        ) {
            LoginScreem(navController)
        }
        composable(
            route = Screen.Home.route,
            arguments = listOf(navArgument(name = DETAIL_ARGUMENT_KEY) {
                type = NavType.StringType
            })
        ) {
            HomeScreen(
                it.arguments?.getString(DETAIL_ARGUMENT_KEY),
                mainViewModel
            )
        }
    }
}