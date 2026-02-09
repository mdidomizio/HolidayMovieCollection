package com.example.holidaymoviecollection.navigation

sealed class Screen (val route: String) {
    object Home : Screen("home")
    object CreateBundle : Screen("createBundle")
    object BundleDetails : Screen ("bundleDetails/{bundleId}"){
        fun createRoute(bundleId: String) = "bundleDetails/$bundleId"
    }
}
