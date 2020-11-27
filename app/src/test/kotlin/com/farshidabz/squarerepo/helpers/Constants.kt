package com.farshidabz.squarerepo.helpers

import com.farshidabz.squarerepo.domain.model.network.RepositoryResponseModel
import com.farshidabz.squarerepo.domain.model.persistence.RepositoryEntity


internal object Constants {
    val REPOSITORIES_API = "/orgs/square/repos"
    val REPOSITORIES_INVALID_API = "https://api.github.com/orgs/square/reposInvalid"

    val FAKE_REPO_NETWORK_MODEL = RepositoryResponseModel(
        id = 1,
        name = "Square Repository",
        description = "this is a fake repository",
        stargazers_count = 10
    )
    val FAKE_RESPONSE_MODEL = listOf(FAKE_REPO_NETWORK_MODEL)

    val FAKE_ENTITY_MODEL = RepositoryEntity(
        id = 1,
        name = "Square Repository",
        startCount = 10,
        isBookmarked = true,
        description = "this is a fake repository"
    )
}