package com.example.holidaymoviecollection.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Bundle(
    @PrimaryKey(autoGenerate = true) val bundleId: Long = 0,
    val name: String
)
