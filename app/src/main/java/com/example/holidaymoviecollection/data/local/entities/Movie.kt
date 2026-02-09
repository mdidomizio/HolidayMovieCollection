package com.example.holidaymoviecollection.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey val movieId: Long,
    val title: String,
    val posterResId: Int
)