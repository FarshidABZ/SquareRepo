package com.farshidabz.squarerepo.view.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farshidabz.squarerepo.domain.model.presentation.RepositoryUIModel
import com.farshidabz.squarerepo.domain.repository.GithubReposRepository
import kotlinx.coroutines.launch

class RepoDetailViewModel @ViewModelInject constructor(private val githubReposRepository: GithubReposRepository) :
    ViewModel() {
    lateinit var repository: RepositoryUIModel
    val isBookmarked = MutableLiveData<Boolean>()

    fun toggleBookmark() {
        viewModelScope.launch {
            isBookmarked.value?.let {
                if (it)
                    removeBookmark()
                else
                    bookmarkRepository()
            }
        }
    }

    private suspend fun removeBookmark() {
        githubReposRepository.removeBookmark(repository)
        isBookmarked.value = false
        repository
    }

    private suspend fun bookmarkRepository() {
        githubReposRepository.bookmarkRepository(repository)
        isBookmarked.value = true
    }
}