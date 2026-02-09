package com.example.holidaymoviecollection.ui.bundlepdpscreen

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.holidaymoviecollection.data.repository.BundleRepository

class BundleDetailsViewModelFactory(
    owner: SavedStateRegistryOwner,
    private val repository: BundleRepository,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
        if (modelClass.isAssignableFrom(BundleDetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BundleDetailsViewModel(repository, handle) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
