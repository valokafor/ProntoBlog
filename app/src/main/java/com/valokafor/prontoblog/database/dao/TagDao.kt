package com.valokafor.prontoblog.database.dao

import androidx.room.*
import com.valokafor.prontoblog.database.entity.TagEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TagDao {
    @Query("SELECT * FROM tags ORDER BY createAt DESC")
    fun getAllTags(): Flow<List<TagEntity>>

    @Query("SELECT * FROM tags WHERE id in(:ids) ORDER BY createAt DESC")
    fun getAllTags(ids:Array<String>): Flow<List<TagEntity>>

    @Query("SELECT * FROM tags WHERE id LIKE :id LIMIT 1")
    suspend fun getTagById(id: String): TagEntity?

    @Query("SELECT * FROM tags WHERE id LIKE :id LIMIT 1")
    fun getTagByIdFlow(id: String): Flow<TagEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tag: TagEntity): Long

    @Update
    suspend fun update(tag: TagEntity): Int

    @Delete
    suspend fun delete(tag: TagEntity)

}