package com.farshidabz.squarerepo.domain.model

import androidx.annotation.Keep

/**
 * Default error model that comes from server if something goes wrong with a repository call
 */
@Keep
data class ErrorModel(
    val message: String?,
    val code: Int?,
    @Transient var errorStatus: ErrorStatus
) {
    constructor(errorStatus: ErrorStatus) : this(null, null, errorStatus)
}