package com.example.holidaymoviecollection.ui.bundlepdpscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.holidaymoviecollection.data.local.relations.BundleWithMovies
import com.example.holidaymoviecollection.data.repository.BundleRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class BundleDetailsViewModel(
    repository: BundleRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val bundleId: Long =
        checkNotNull(savedStateHandle["bundleId"])

    val bundle: StateFlow<BundleWithMovies?> =
        repository.getBundleWithMovies(bundleId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )

}
