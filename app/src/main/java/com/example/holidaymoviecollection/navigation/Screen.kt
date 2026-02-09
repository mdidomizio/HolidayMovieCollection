package com.example.holidaymoviecollection.navigation

sealed class Screen (val route: String) {
    object Home : Screen("home")
    object CreateBundle : Screen("create_bundle")
    object BundleDetails : Screen ("bundleDetails/{bundleId}"){
        fun createRoute(bundleId: Long): String {
            return "bundleDetails/$bundleId"
        }
    }
}
