package com.example.holidaymoviecollection.ui.createbundle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.holidaymoviecollection.data.repository.BundleRepository
import com.example.holidaymoviecollection.data.repository.MovieRepository

class ViewModelFactory(
    private val movieRepository: MovieRepository,
    private val bundleRepository: BundleRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateBundleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CreateBundleViewModel(movieRepository, bundleRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
