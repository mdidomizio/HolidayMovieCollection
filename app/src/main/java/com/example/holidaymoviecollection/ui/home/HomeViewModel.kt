package com.example.holidaymoviecollection.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.holidaymoviecollection.data.local.relations.BundleWithMovies
import com.example.holidaymoviecollection.data.repository.BundleRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val repository: BundleRepository
) : ViewModel() {
    val bundles: StateFlow<List<BundleWithMovies>> =
        repository.getBundlesWithMovies()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = emptyList()
            )

}
