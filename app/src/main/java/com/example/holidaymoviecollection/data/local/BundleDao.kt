package com.example.holidaymoviecollection.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.holidaymoviecollection.data.local.entities.Bundle
import com.example.holidaymoviecollection.data.local.entities.BundleMovieCrossRef
import com.example.holidaymoviecollection.data.local.relations.BundleWithMovies
import kotlinx.coroutines.flow.Flow

@Dao
interface BundleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBundle(bundles: Bundle): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBundleMovieCrossRefs(
        crossRefs: List<BundleMovieCrossRef>
    )

    @Query("SELECT * FROM bundle")
    suspend fun getAllBundles(): List<Bundle>

    @Transaction
    @Query("SELECT * FROM bundle")
    fun getBundlesWithMovies(): Flow<List<BundleWithMovies>>

    @Transaction
    @Query("SELECT * FROM bundle WHERE bundleId = :bundleId")
    fun getBundleWithMovies(bundleId: Long): Flow<BundleWithMovies?>
}
