package com.farshidabz.squarerepo.domain.model.persistence

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "repositories")
data class RepositoryEntity(
    @PrimaryKey(autoGenerate = false) val id: Long = 1,
    val name: String,
    val startCount: Int,
    val isBookmarked: Boolean,
    val description: String
)