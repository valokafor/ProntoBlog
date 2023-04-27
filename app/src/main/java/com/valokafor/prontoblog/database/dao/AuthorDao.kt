package com.valokafor.prontoblog.database.dao

import androidx.room.*
import com.valokafor.prontoblog.database.entity.AuthorEntity
import com.valokafor.prontoblog.database.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthorDao {
    @Query("SELECT * FROM author ORDER BY createAt DESC")
    fun getAuthors(): Flow<List<AuthorEntity>>

    @Query("SELECT * FROM author WHERE id LIKE :id LIMIT 1")
    suspend fun getAuthorById(id: String): AuthorEntity?

    @Query("SELECT * FROM author WHERE id LIKE :id LIMIT 1")
    fun getAuthorByIdFlow(id: String): Flow<AuthorEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(author: AuthorEntity): Long

    @Update
    suspend fun update(author: AuthorEntity): Int

    @Delete
    suspend fun delete(author: AuthorEntity)

}