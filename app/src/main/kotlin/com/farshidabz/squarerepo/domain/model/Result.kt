package com.farshidabz.squarerepo.domain.model

import androidx.annotation.Keep

/**
 * Default result model that comes from server or local.
 *
 * @param status the Status is status of task could be SUCCESS or ERROR
 * @param errorModel the ErrorModel, if task result will not SUCCESS, then errorModel will filed with ErrorModel object
 */

@Keep
data class Result<out T>(val status: Status, val data: T?, val errorModel: ErrorModel?) {

    enum class Status {
        SUCCESS,
        ERROR
    }

    companion object {
        fun <T> success(data: T): Result<T> = Result(Status.SUCCESS, data, null)
        fun <T> error(errorModel: ErrorModel?): Result<T> = Result(Status.ERROR, null, errorModel)
    }
}