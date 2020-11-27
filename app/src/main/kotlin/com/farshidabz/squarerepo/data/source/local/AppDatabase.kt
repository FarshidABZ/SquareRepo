package com.farshidabz.squarerepo.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.farshidabz.squarerepo.data.source.local.dao.RepositoryDao
import com.farshidabz.squarerepo.domain.model.persistence.RepositoryEntity

@Database(entities = [RepositoryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repositoryDao(): RepositoryDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "repositories")
                .fallbackToDestructiveMigration()
                .build()
    }
}