package com.farshidabz.squarerepo.data.mapper

import com.farshidabz.squarerepo.domain.model.persistence.RepositoryEntity
import com.farshidabz.squarerepo.domain.model.presentation.RepositoryUIModel

/**
 * Extension function to convert list of locale entity model to presentation model
 * */
fun List<RepositoryEntity>?.toRepositoryUIModel(): List<RepositoryUIModel> {
    val uiModelList = mutableListOf<RepositoryUIModel>()

    this?.forEach {
        with(it) {
            uiModelList.add(RepositoryUIModel(id, name, startCount, isBookmarked, description))
        }
    }
    return uiModelList
}