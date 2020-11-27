package com.farshidabz.squarerepo.view.repolist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.farshidabz.squarerepo.data.mapper.toRepositoryUIModel
import com.farshidabz.squarerepo.domain.model.ErrorModel
import com.farshidabz.squarerepo.domain.model.Result
import com.farshidabz.squarerepo.domain.model.presentation.RepositoryUIModel
import com.farshidabz.squarerepo.domain.repository.GithubReposRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RepositoryListViewModel @ViewModelInject constructor(private val githubReposRepository: GithubReposRepository) :
    ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val errorModel = MutableLiveData<ErrorModel>()

    private val forceToRefresh = MutableLiveData<Boolean>().apply { value = true }

    val repositoryList: MutableLiveData<List<RepositoryUIModel>>
        get() = _repositoryList as MutableLiveData<List<RepositoryUIModel>>

    private var _repositoryList: LiveData<List<RepositoryUIModel>> = forceToRefresh.switchMap {
        isLoading.value = true
        getRepositories()
    }

    private fun getRepositories() = liveData {
        isLoading.value = true
        githubReposRepository.getRepositories().collect {
            when (it.status) {
                Result.Status.ERROR -> errorModel.value = it.errorModel
                Result.Status.SUCCESS -> {
                    isLoading.value = false
                    emit(it.data.toRepositoryUIModel())
                }
            }
        }
    }

    fun observeDb() {
        viewModelScope.launch {
            githubReposRepository.observerData().collect {
                repositoryList.value = it.data?.toRepositoryUIModel()
            }
        }
    }

    fun refreshList() {
        forceToRefresh.value = true
    }
}