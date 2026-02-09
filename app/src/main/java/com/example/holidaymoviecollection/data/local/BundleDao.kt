package com.example.holidaymoviecollection.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.holidaymoviecollection.data.local.entities.Bundle
import com.example.holidaymoviecollection.data.local.entities.BundleMovieCrossRef
import com.example.holidaymoviecollection.data.local.relations.BundleWithMovies

@Dao
interface BundleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBundle(bundles: Bundle)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBundleMovieCrossRefs(
        crossRefs: List<BundleMovieCrossRef>
    )

    @Query("SELECT * FROM Bundle")
    suspend fun getAllBundles(): List<Bundle>

    @Transaction
    @Query("SELECT * FROM Bundle")
    suspend fun fetBundlesWithMovies(): List<BundleWithMovies>
}
