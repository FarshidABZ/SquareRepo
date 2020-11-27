package com.farshidabz.squarerepo.fake

import com.farshidabz.squarerepo.domain.model.ErrorModel
import com.farshidabz.squarerepo.domain.model.ErrorStatus
import com.farshidabz.squarerepo.domain.model.Result
import com.farshidabz.squarerepo.domain.model.presentation.RepositoryUIModel
import com.farshidabz.squarerepo.domain.repository.GithubReposRepository
import com.farshidabz.squarerepo.helpers.Constants.FAKE_ENTITY_MODEL
import kotlinx.coroutines.flow.flow
import org.junit.Test

class FakeGithubReposRepository : GithubReposRepository {
    private var shouldReturnError = false

    fun setReturnError(value: Boolean) {
        shouldReturnError = value
    }

    @Test
    override suspend fun getRepositories() = flow {
        if (shouldReturnError) {
            emit(Result.error(ErrorModel("Not Found", 404, ErrorStatus.INVALID_PARAMETERS)))
        } else {
            emit(Result.success(listOf(FAKE_ENTITY_MODEL)))
        }
    }

    @Test
    override suspend fun bookmarkRepository(repo: RepositoryUIModel) {
        TODO("Not yet implemented")
    }

    @Test
    override suspend fun removeBookmark(repo: RepositoryUIModel) {
        TODO("Not yet implemented")
    }

    @Test
    override suspend fun observerData() = flow { emit(Result.success(listOf(FAKE_ENTITY_MODEL))) }
}