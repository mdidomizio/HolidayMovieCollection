package com.example.holidaymoviecollection.navigation

sealed class Screen (val route: String) {
    object Home : Screen("home")
    object CreateBundle : Screen("createBundle")
    object BundleDetails : Screen ("bundleDetails")

    /*object Home : Screen("home")
    object Gallery : Screen("gallery/{destinationTitle}") {
        fun createRoute(destinationTitle: String) = "gallery/$destinationTitle"
    }*/
}
