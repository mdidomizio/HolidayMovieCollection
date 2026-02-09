package com.example.holidaymoviecollection.data.repository

import com.example.holidaymoviecollection.data.local.MovieDao
import com.example.holidaymoviecollection.data.local.entities.Movie
import kotlinx.coroutines.flow.Flow

class MovieRepository (
    private val movieDao: MovieDao
) {
    fun getAllMovies(): Flow<List<Movie>> =
        movieDao.getAllMovies()
}
