package com.example.holidaymoviecollection.navigation

sealed class Screen (val route: String) {
    object Home : Screen("home")
    object AddBundle : Screen("addBundle")
}