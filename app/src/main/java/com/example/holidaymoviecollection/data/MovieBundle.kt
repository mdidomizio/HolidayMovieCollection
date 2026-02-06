package com.example.holidaymoviecollection.data

import androidx.annotation.DrawableRes
import com.example.holidaymoviecollection.R

data class MovieBundle(
    val id: Int,
    val name: String,
    val movies: List<Any>,
    @DrawableRes val icon: Int = R.drawable.folder_icon
)
val mockBundles = listOf(
    MovieBundle (1, "A Title 1", emptyList()),
    MovieBundle (2, "b Title 2", listOf(1)),
    MovieBundle (3, "c Title 3", listOf(1,2)),
    MovieBundle (4, "D Title 4", listOf(1,2,3)),
    MovieBundle (5, "E Title 5", listOf(1,2,3,4)),
    MovieBundle (1, "s Title 1", emptyList()),
    MovieBundle (2, "n Title 2", listOf(1)),
    MovieBundle (3, "Title 3", listOf(1,2)),
    MovieBundle (4, "Title 4", listOf(1,2,3)),
    MovieBundle (5, "Title 5", listOf(1,2,3,4)),
    MovieBundle (1, "Title 1", emptyList()),
    MovieBundle (2, "Title 2", listOf(1)),
    MovieBundle (3, "Title 3", listOf(1,2)),
    MovieBundle (4, "Title 4", listOf(1,2,3)),
    MovieBundle (5, "Title 5", listOf(1,2,3,4)),
    MovieBundle (1, "Title 1", emptyList()),
    MovieBundle (2, "Title 2", listOf(1)),
    MovieBundle (3, "Title 3", listOf(1,2)),
    MovieBundle (4, "Title 4", listOf(1,2,3)),
    MovieBundle (5, "Title 5", listOf(1,2,3,4)),
    MovieBundle (1, "Title 1", emptyList()),
    MovieBundle (2, "Title 2", listOf(1)),
    MovieBundle (3, "Title 3", listOf(1,2)),
    MovieBundle (4, "Title 4", listOf(1,2,3)),
    MovieBundle (5, "Title 5", listOf(1,2,3,4)),
)