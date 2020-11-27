package com.farshidabz.squarerepo.view.repolist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.farshidabz.squarerepo.MainCoroutineRule
import com.farshidabz.squarerepo.fake.FakeGithubReposRepository
import com.farshidabz.squarerepo.getOrAwaitValue
import com.farshidabz.squarerepo.observeForTesting
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class RepositoryListViewModelTest {
    private lateinit var fakeGithubReposRepository: FakeGithubReposRepository
    private lateinit var repositoryListViewModel: RepositoryListViewModel

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        fakeGithubReposRepository = FakeGithubReposRepository()
        repositoryListViewModel = RepositoryListViewModel(fakeGithubReposRepository)
    }

    @Test
    fun `get repositories and return success`() {
        fakeGithubReposRepository.setReturnError(false)

        repositoryListViewModel.refreshList()

        repositoryListViewModel.repositoryList.observeForTesting {
            assertThat(
                repositoryListViewModel.repositoryList.getOrAwaitValue().isEmpty(),
                `is`(false)
            )
        }
    }

    @Test
    fun `get repositories and return error`() {
        fakeGithubReposRepository.setReturnError(true)

        repositoryListViewModel.refreshList()

        repositoryListViewModel.repositoryList.observeForTesting {
            assertThat(
                repositoryListViewModel.errorModel.getOrAwaitValue().code,
                `is`(404)
            )
        }
    }
}