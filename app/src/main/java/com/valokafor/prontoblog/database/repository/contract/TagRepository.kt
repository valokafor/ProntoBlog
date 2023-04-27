package com.valokafor.prontoblog.database.repository.contract

import com.valokafor.prontoblog.database.entity.TagEntity
import kotlinx.coroutines.flow.Flow

interface TagRepository {
    fun getAllTags(): Flow<List<TagEntity>>
    fun getAllTags(ids: Array<String>): Flow<List<TagEntity>>
    suspend fun getTagById(tagId: String): TagEntity?
    fun getTagByIdFlow(tagId: String): Flow<TagEntity>
    suspend fun insert(tag: TagEntity): Long
    suspend fun update(tag: TagEntity): Int
    suspend fun delete(tag: TagEntity)
}