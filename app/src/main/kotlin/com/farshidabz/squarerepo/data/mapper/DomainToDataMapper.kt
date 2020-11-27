package com.farshidabz.squarerepo.data.mapper

import com.farshidabz.squarerepo.domain.model.network.RepositoryResponseModel
import com.farshidabz.squarerepo.domain.model.persistence.RepositoryEntity

/**
 * Extension function to convert network response to local entity model
 * */
fun RepositoryResponseModel.toLocalEntity(isBookmark: Boolean) =
    RepositoryEntity(
        id = id,
        name = name ?: "",
        startCount = stargazers_count,
        isBookmarked = isBookmark,
        description = description ?: ""
    )