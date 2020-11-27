package com.farshidabz.squarerepo.di

import com.farshidabz.squarerepo.data.repository.GithubReposRepositoryImpl
import com.farshidabz.squarerepo.data.source.local.dao.RepositoryDao
import com.farshidabz.squarerepo.data.source.remote.RepoApiService
import com.farshidabz.squarerepo.data.source.remote.RemoteRepoListDataSource
import com.farshidabz.squarerepo.domain.repository.GithubReposRepository
import com.farshidabz.squarerepo.domain.source.RepoListDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepoListRemoteDataSource(repoApiService: RepoApiService): RepoListDataSource =
        RemoteRepoListDataSource(repoApiService)

    @Singleton
    @Provides
    fun provideGithubReposRepository(
        remoteDataSource: RepoListDataSource,
        localDataSource: RepositoryDao
    ): GithubReposRepository = GithubReposRepositoryImpl(remoteDataSource, localDataSource)
}