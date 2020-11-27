package com.farshidabz.squarerepo.data.repository

import com.farshidabz.squarerepo.data.mapper.toLocalEntity
import com.farshidabz.squarerepo.data.source.local.dao.RepositoryDao
import com.farshidabz.squarerepo.domain.model.Result
import com.farshidabz.squarerepo.domain.model.network.RepositoryResponseModel
import com.farshidabz.squarerepo.domain.model.presentation.RepositoryUIModel
import com.farshidabz.squarerepo.domain.repository.GithubReposRepository
import com.farshidabz.squarerepo.domain.source.RepoListDataSource
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class GithubReposRepositoryImpl(
    private val remoteDataSource: RepoListDataSource,
    private val localDataSource: RepositoryDao
) : GithubReposRepository {
    private suspend fun insertDataToDb(data: List<RepositoryResponseModel>?) {
        data?.forEach {
            localDataSource.insert(
                it.toLocalEntity(localDataSource.get(it.id)?.isBookmarked ?: false)
            )
        }
    }

    override suspend fun getRepositories() = flow {
        val response = remoteDataSource.getRepositories()
        when (response.status) {
            Result.Status.SUCCESS -> {
                insertDataToDb(response.data)
            }
            else -> {
                emit(Result.error(response.errorModel))
            }
        }

        emit(Result.success(localDataSource.getAll()))
    }

    override suspend fun bookmarkRepository(repo: RepositoryUIModel) {
        localDataSource.update(repo.id, true)
    }

    override suspend fun removeBookmark(repo: RepositoryUIModel) {
        localDataSource.update(repo.id, false)
    }

    override suspend fun observerData() = localDataSource.observerData().map { Result.success(it) }
}