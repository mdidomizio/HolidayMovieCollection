package com.example.holidaymoviecollection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.holidaymoviecollection.navigation.AppNavigation
import com.example.holidaymoviecollection.ui.HomeScreen
import com.example.holidaymoviecollection.ui.theme.HolidayMovieCollectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HolidayMovieCollectionTheme {
                AppNavigation()
            }
        }
    }
}
