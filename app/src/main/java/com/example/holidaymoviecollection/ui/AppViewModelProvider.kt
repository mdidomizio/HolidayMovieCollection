package com.example.holidaymoviecollection.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.holidaymoviecollection.HolidayMovieCollectionApplication
import com.example.holidaymoviecollection.ui.home.HomeViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                holidayMovieCollectionApplication().bundleRepository
            )
        }
    }
}

fun CreationExtras.holidayMovieCollectionApplication(): HolidayMovieCollectionApplication = 
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as HolidayMovieCollectionApplication)
