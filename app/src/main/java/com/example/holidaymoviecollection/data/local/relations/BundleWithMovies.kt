package com.example.holidaymoviecollection.data.local.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.holidaymoviecollection.data.local.entities.Bundle
import com.example.holidaymoviecollection.data.local.entities.BundleMovieCrossRef
import com.example.holidaymoviecollection.data.local.entities.Movie

data class BundleWithMovies(

    @Embedded
    val bundle: Bundle,

    @Relation(
        parentColumn = "bundleId",
        entityColumn = "movieId",
        associateBy = Junction(BundleMovieCrossRef::class)
    )
    val movies: List<Movie>
)
