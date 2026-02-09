package com.example.holidaymoviecollection.data.repository

import com.example.holidaymoviecollection.data.local.BundleDao
import com.example.holidaymoviecollection.data.local.entities.Bundle
import com.example.holidaymoviecollection.data.local.entities.BundleMovieCrossRef
import com.example.holidaymoviecollection.data.local.entities.Movie
import com.example.holidaymoviecollection.data.local.relations.BundleWithMovies
import kotlinx.coroutines.flow.Flow

class BundleRepository(
    private val bundleDao: BundleDao
) {
    fun getBundlesWithMovies(): Flow<List<BundleWithMovies>> =
         bundleDao.getBundlesWithMovies()

    fun getBundleWithMovies(bundleId: Long): Flow<BundleWithMovies?> =
         bundleDao.getBundleWithMovies(bundleId)

    suspend fun createBundle(name: String, movies: List<Movie>) {
        val bundle = Bundle(name = name)
        val bundleId = bundleDao.insertBundle(bundle)
        val crossRefs = movies.map { movie ->
            BundleMovieCrossRef(bundleId, movie.movieId)
        }
        bundleDao.insertBundleMovieCrossRefs(crossRefs)
    }
}
