package com.valokafor.prontoblog.database.repository.local

import com.valokafor.prontoblog.database.dao.TagDao
import com.valokafor.prontoblog.database.entity.TagEntity
import com.valokafor.prontoblog.database.repository.contract.TagRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TagRepositoryLocal @Inject constructor(private val dao: TagDao): TagRepository {
    override fun getAllTags(): Flow<List<TagEntity>> {
        return dao.getAllTags()
    }

    override fun getAllTags(ids: Array<String>): Flow<List<TagEntity>> {
        return dao.getAllTags(ids)
    }

    override suspend fun getTagById(tagId: String): TagEntity? {
        return withContext(Dispatchers.IO) {
            dao.getTagById(tagId)
        }
    }

    override fun getTagByIdFlow(tagId: String): Flow<TagEntity> {
        return dao.getTagByIdFlow(tagId)
    }

    override suspend fun insert(tag: TagEntity): Long {
        return withContext(Dispatchers.IO) {
            dao.insert(tag)
        }
    }

    override suspend fun update(tag: TagEntity): Int {
        return withContext(Dispatchers.IO) {
            dao.update(tag)
        }
    }

    override suspend fun delete(tag: TagEntity) {
        return withContext(Dispatchers.IO) {
            dao.delete(tag)
        }
    }
}