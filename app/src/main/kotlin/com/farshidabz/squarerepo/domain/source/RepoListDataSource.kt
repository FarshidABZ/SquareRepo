package com.farshidabz.squarerepo.domain.source

import com.farshidabz.squarerepo.domain.model.Result
import com.farshidabz.squarerepo.domain.model.network.RepositoryResponseModel

interface RepoListDataSource {
    suspend fun getRepositories(): Result<List<RepositoryResponseModel>?>
}