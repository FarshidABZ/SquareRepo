package com.farshidabz.squarerepo.data.source.local.dao

import androidx.room.*
import com.farshidabz.squarerepo.domain.model.persistence.RepositoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RepositoryDao {
    @Query("SELECT * FROM repositories WHERE id=:id")
    suspend fun get(id: Long): RepositoryEntity?

    @Query("SELECT * FROM repositories")
    suspend fun getAll(): List<RepositoryEntity>

    @Query("UPDATE repositories SET isBookmarked=:isBookmark WHERE id=:id")
    suspend fun update(id: Long, isBookmark: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: RepositoryEntity)

    @Query("SELECT * FROM REPOSITORIES")
    fun observerData(): Flow<List<RepositoryEntity>>
}