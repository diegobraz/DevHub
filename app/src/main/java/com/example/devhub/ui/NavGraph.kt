package com.example.devhub.ui

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.devhub.ui.componentes.HomeScreem
import com.example.devhub.ui.componentes.LoginScreem

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    mainViewModel: MainViewModel
){
    NavHost(navController = navController, startDestination = Screen.login.route){
        composable(
            route = Screen.login.route
        ){
            LoginScreem(navController)
        }
      composable(
          route = Screen.home.route,
          arguments = listOf(navArgument(name = DETAIL_ARGUMENT_KEY){
              type = NavType.StringType
          })
      ){
          HomeScreem(
              it.arguments?.getString( DETAIL_ARGUMENT_KEY),
              mainViewModel
          )
      }
    }
}