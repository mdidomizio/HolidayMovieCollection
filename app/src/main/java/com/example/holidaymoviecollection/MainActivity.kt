package com.example.holidaymoviecollection

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.holidaymoviecollection.navigation.AppNavigation
import com.example.holidaymoviecollection.ui.theme.HolidayMovieCollectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                Color.TRANSPARENT,
                Color.TRANSPARENT,
            ) { isDarkTheme ->
                true
            }
        )
        setContent {
            HolidayMovieCollectionTheme {
                AppNavigation()
            }
        }
    }
}
