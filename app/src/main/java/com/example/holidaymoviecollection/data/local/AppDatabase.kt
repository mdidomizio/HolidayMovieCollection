package com.example.holidaymoviecollection.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.holidaymoviecollection.data.local.entities.Bundle
import com.example.holidaymoviecollection.data.local.entities.BundleMovieCrossRef
import com.example.holidaymoviecollection.data.local.entities.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [
        Movie::class,
        Bundle::class,
        BundleMovieCrossRef::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun bundleDao(): BundleDao

    companion object {
        fun create(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "movie_bundles_db"
            )
                .addCallback(object : Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    // seed database once
                        CoroutineScope(Dispatchers.IO).launch {
                            val database = getInstance(context)
                            database.movieDao()
                                .insertAll(DatabaseSeeder.getPredefinedMovies())
                        }
                    }
                })
                .build()
        }
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: create(context).also { INSTANCE = it}
            }
    }
}
