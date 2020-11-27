package com.farshidabz.squarerepo.data.source.remote

import com.farshidabz.squarerepo.domain.model.network.RepositoryResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface RepoApiService {
    @GET("orgs/square/repos")
    suspend fun getRepoList(): Response<List<RepositoryResponseModel>>
}