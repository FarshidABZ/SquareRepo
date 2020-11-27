package com.farshidabz.squarerepo.domain.model.presentation

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class RepositoryUIModel(
    val id: Long,
    val name: String,
    val startCount: Int,
    val isBookmarked: Boolean,
    val description: String
) : Parcelable