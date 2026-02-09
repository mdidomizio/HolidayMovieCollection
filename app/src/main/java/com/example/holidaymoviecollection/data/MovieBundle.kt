package com.example.holidaymoviecollection.data

import androidx.annotation.DrawableRes
import com.example.holidaymoviecollection.R

data class MovieBundle(
    val id: String,
    val name: String,
    val movies: List<Any>,
    @DrawableRes val icon: Int = R.drawable.folder_icon
)
val mockBundles = listOf(
    MovieBundle ("1", "A Title 1", emptyList()),
    MovieBundle ("2", "b Title 2", listOf(1)),
    MovieBundle ("3", "c Title 3", listOf(1,2)),
    MovieBundle ("4", "D Title 4", listOf(1,2,3)),
    MovieBundle ("5", "E Title 5", listOf(1,2,3,4)),
    MovieBundle ("6", "s Title 1", emptyList()),
    MovieBundle ("7", "n Title 2", listOf(1)),
    MovieBundle ("8", "Title 3", listOf(1,2)),
    MovieBundle ("9", "Title 4", listOf(1,2,3)),
    MovieBundle ("10", "Title 5", listOf(1,2,3,4)),
    MovieBundle ("11", "Title 1", emptyList()),
    MovieBundle ("12", "Title 2", listOf(1)),
    MovieBundle ("13", "Title 3", listOf(1,2)),
    MovieBundle ("14", "Title 4", listOf(1,2,3)),
    MovieBundle ("15", "Title 5", listOf(1,2,3,4)),
    MovieBundle ("16", "Title 1", emptyList()),
    MovieBundle ("17", "Title 2", listOf(1)),
    MovieBundle ("18", "Title 3", listOf(1,2)),
    MovieBundle ("19", "Title 4", listOf(1,2,3)),
    MovieBundle ("20", "Title 5", listOf(1,2,3,4)),
    MovieBundle ("21", "Title 1", emptyList()),
    MovieBundle ("22", "Title",  listOf(1)),
    MovieBundle ("23", "Title 3", listOf(1,2)),
    MovieBundle ("24", "Title 4", listOf(1,2,3)),
    MovieBundle ("25", "Title 5", listOf(1,2,3,4)),
)