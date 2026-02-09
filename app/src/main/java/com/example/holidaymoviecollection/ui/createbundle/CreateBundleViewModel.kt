package com.example.holidaymoviecollection.ui.createbundle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.holidaymoviecollection.data.repository.BundleRepository
import kotlinx.coroutines.flow.StateFlow
import com.example.holidaymoviecollection.data.local.entities.Movie
import com.example.holidaymoviecollection.data.repository.MovieRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CreateBundleViewModel(
    private val movieRepository: MovieRepository,
    private val bundleRepository: BundleRepository
) : ViewModel() {
    val movies: StateFlow<List<Movie>> =
        movieRepository.getAllMovies()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            emptyList()
        )
    var bundleName by mutableStateOf("")
        private set
    private val _selectedMovies = mutableStateListOf<Movie>()
    val selectedMovies: List<Movie> get() = _selectedMovies
    private val _saveCompleted = MutableSharedFlow<Unit>()
    val saveCompleted = _saveCompleted.asSharedFlow()

    fun onBundleNameChanged(name: String){
        bundleName = name
    }

    fun onMovieClicked(movie: Movie) {
        if (_selectedMovies.contains(movie)) {
            _selectedMovies.remove(movie)
        } else {
            _selectedMovies.add(movie)
        }
    }

    fun saveBundle() {
        viewModelScope.launch {
            bundleRepository.createBundle(
                name = bundleName,
                movies = _selectedMovies
            )
            _saveCompleted.emit(Unit)
        }
    }
    val isSaveEnabled: Boolean
        get() = bundleName.isNotBlank() && _selectedMovies.isNotEmpty()
}