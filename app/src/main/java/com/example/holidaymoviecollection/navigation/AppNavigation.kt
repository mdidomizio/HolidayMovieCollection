package com.example.holidaymoviecollection.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.holidaymoviecollection.ui.bundlepdpscreen.BundleDetailsScreen
import com.example.holidaymoviecollection.ui.createbundle.CreateBundleScreen
import com.example.holidaymoviecollection.ui.home.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onFabClicked = {
                    navController.navigate(Screen.CreateBundle.route)
                },
                onBundleItemClicked = { bundleId ->
                    navController.navigate(
                        route = Screen.BundleDetails.createRoute(bundleId)
                    )
                }
            )
        }
        composable(Screen.CreateBundle.route) {
            CreateBundleScreen(
                onBackClicked = {
                    navController.popBackStack()
                },
                onSaveBundleClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = Screen.BundleDetails.route,
            arguments = listOf(
                navArgument("bundleId") {
                    type = NavType.LongType
                }
            )
        ) { backStackEntry ->
            val bundleId = backStackEntry.arguments?.getLong("bundleId")
                ?: return@composable

            BundleDetailsScreen(
                bundleId = bundleId,
                onBackClicked = {
                    navController.popBackStack()
                }
            )
        }
    }
}
