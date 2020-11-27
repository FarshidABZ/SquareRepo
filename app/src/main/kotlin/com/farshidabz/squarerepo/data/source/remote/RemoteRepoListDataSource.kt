package com.farshidabz.squarerepo.data.source.remote

import com.farshidabz.squarerepo.domain.source.BaseDataSource
import com.farshidabz.squarerepo.domain.source.RepoListDataSource

class RemoteRepoListDataSource(private val repoApiService: RepoApiService) :
    BaseDataSource(), RepoListDataSource {
    override suspend fun getRepositories() = getResult { repoApiService.getRepoList() }
}