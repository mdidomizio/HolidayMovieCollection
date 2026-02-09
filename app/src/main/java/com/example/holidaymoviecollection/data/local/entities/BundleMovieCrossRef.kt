package com.example.holidaymoviecollection.data.local.entities

import androidx.room.Entity

@Entity(primaryKeys = ["bundleId", "movieId"])
data class BundleMovieCrossRef(
    val bundleId: Long,
    val movieId: Long
)
