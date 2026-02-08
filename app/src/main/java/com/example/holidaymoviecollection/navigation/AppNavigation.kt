package com.example.holidaymoviecollection.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.holidaymoviecollection.ui.createbundle.CreateBundleScreen
import com.example.holidaymoviecollection.ui.home.HomeScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onFabClicked = {
                    navController.navigate(Screen.CreateBundle.route)
                }
            )
        }
        composable (Screen.CreateBundle.route){
            CreateBundleScreen(
                onBackClicked = {
                    navController.popBackStack()
                },
                onSaveBundleClicked = {
                    navController.popBackStack()
                }
            )
        }
    }
}
