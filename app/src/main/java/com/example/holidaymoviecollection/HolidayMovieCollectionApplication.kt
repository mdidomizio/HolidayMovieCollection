package com.example.holidaymoviecollection

import android.app.Application
import com.example.holidaymoviecollection.data.local.AppDatabase
import com.example.holidaymoviecollection.data.repository.BundleRepository
import com.example.holidaymoviecollection.data.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class HolidayMovieCollectionApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    val database: AppDatabase by lazy {
        AppDatabase.getInstance(this).also { db ->
            /*applicationScope.launch {
                db.openHelper.writableDatabase
            }*/
            applicationScope.launch {
                try {
                    db.bundleDao().getBundlesWithMovies().first()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    val movieRepository: MovieRepository by lazy { MovieRepository(database.movieDao()) }
    val bundleRepository: BundleRepository by lazy { BundleRepository(database.bundleDao()) }
}
