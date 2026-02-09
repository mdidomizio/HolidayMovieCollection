package com.example.holidaymoviecollection

import android.app.Application
import com.example.holidaymoviecollection.data.local.AppDatabase
import com.example.holidaymoviecollection.data.repository.BundleRepository
import com.example.holidaymoviecollection.data.repository.MovieRepository

class HolidayMovieCollectionApplication : Application() {

    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }

    val movieRepository: MovieRepository by lazy { MovieRepository(database.movieDao()) }
    val bundleRepository: BundleRepository by lazy { BundleRepository(database.bundleDao()) }
}
