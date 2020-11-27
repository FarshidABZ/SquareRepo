package com.farshidabz.squarerepo.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.farshidabz.squarerepo.BaseTest
import com.farshidabz.squarerepo.data.source.local.dao.RepositoryDao
import com.farshidabz.squarerepo.data.source.remote.RemoteRepoListDataSource
import com.farshidabz.squarerepo.data.source.remote.RepoApiService
import com.farshidabz.squarerepo.domain.model.Result
import com.farshidabz.squarerepo.domain.source.RepoListDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@Config(sdk = [Config.OLDEST_SDK])
internal class GithubReposRepositoryImplTest : BaseTest() {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var localDataSource: RepositoryDao
    private lateinit var remoteDataSource: RepoListDataSource

    private lateinit var githubReposRepository: GithubReposRepositoryImpl

    @ExperimentalCoroutinesApi
    @Before
    override fun setup() {
        super.setup()
        localDataSource = super.database.repositoryDao()
        remoteDataSource = RemoteRepoListDataSource(getApiService(RepoApiService::class.java))
        githubReposRepository = GithubReposRepositoryImpl(remoteDataSource, localDataSource)
    }

    @Test
    fun `get repositories return success value`() {
        runBlocking {
            val result = githubReposRepository.getRepositories()
            result.collect {
                assertThat(it.status, `is`(Result.Status.SUCCESS))
            }
        }
    }

    @Test
    fun `get repositories return not null repo list`() {
        runBlocking {
            val result = githubReposRepository.getRepositories()
            result.collect {
                assertThat(it.data, `is`(notNullValue()))
            }
        }
    }

    @Test
    fun `get repositories return repo list`() {
        runBlocking {
            val result = githubReposRepository.getRepositories()
            result.collect {
                assertThat(it.data!!.isEmpty(), `is`(false))
            }
        }
    }
}