package com.farshidabz.squarerepo.di

import android.content.Context
import com.farshidabz.squarerepo.data.source.local.AppDatabase
import com.farshidabz.squarerepo.data.source.local.dao.RepositoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object PersistenceModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCharacterDao(db: AppDatabase): RepositoryDao = db.repositoryDao()
}