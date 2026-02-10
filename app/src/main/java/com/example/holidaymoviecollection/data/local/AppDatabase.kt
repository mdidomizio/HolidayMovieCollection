package com.example.holidaymoviecollection.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.holidaymoviecollection.data.local.entities.Bundle
import com.example.holidaymoviecollection.data.local.entities.BundleMovieCrossRef
import com.example.holidaymoviecollection.data.local.entities.Movie
import java.lang.Exception

@Database(
    entities = [
        Movie::class,
        Bundle::class,
        BundleMovieCrossRef::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun bundleDao(): BundleDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it}
            }
        }


        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "movie_bundles_db.db"
            )
                .createFromAsset("database/movie_bundles_db.db")
                //.addCallback(DatabaseCallback(context))
                .build()
        }
        private class DatabaseCallback(
            private val context: Context
        ) : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                db.execSQL("BEGIN TRANSACTION")
                try {
                    DatabaseSeeder.getPredefinedMovies().forEach { movie ->
                        db.execSQL(
                            "INSERT INTO Movie(movieId, title, posterResId) VALUES (?, ?, ?)",
                            arrayOf(
                                movie.movieId,
                                movie.title,
                                movie.posterResId
                            )
                        )
                    }
                    db.execSQL("COMMIT")
                } catch (e: Exception) {
                    db.execSQL("ROLLBACK")
                    throw e
                }
            }
        }
    }
}
