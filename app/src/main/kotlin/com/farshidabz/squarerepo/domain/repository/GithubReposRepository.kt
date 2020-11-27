package com.farshidabz.squarerepo.domain.repository

import com.farshidabz.squarerepo.domain.model.Result
import com.farshidabz.squarerepo.domain.model.persistence.RepositoryEntity
import com.farshidabz.squarerepo.domain.model.presentation.RepositoryUIModel
import kotlinx.coroutines.flow.Flow

interface GithubReposRepository {
    suspend fun getRepositories(): Flow<Result<List<RepositoryEntity>>>
    suspend fun bookmarkRepository(repo: RepositoryUIModel)
    suspend fun removeBookmark(repo: RepositoryUIModel)
    suspend fun observerData(): Flow<Result<List<RepositoryEntity>>>
}