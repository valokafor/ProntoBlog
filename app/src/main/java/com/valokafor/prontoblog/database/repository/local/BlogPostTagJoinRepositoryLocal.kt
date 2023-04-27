package com.valokafor.prontoblog.database.repository.local

import com.valokafor.prontoblog.database.dao.BlogPostTagJoinDao
import com.valokafor.prontoblog.database.entity.BlogPostTagJoin
import com.valokafor.prontoblog.database.repository.contract.BlogPostTagJoinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BlogPostTagJoinRepositoryLocal @Inject constructor(private val dao: BlogPostTagJoinDao)
    : BlogPostTagJoinRepository{

    override fun getBlogPostRefs(blogPostId: String): Flow<List<BlogPostTagJoin>> {
        return dao.getBlogPostRefs(blogPostId)
    }

    override fun getTagRefs(tagId: String): Flow<List<BlogPostTagJoin>> {
        return dao.getTagRefs(tagId)
    }

    override suspend fun insert(ref: BlogPostTagJoin): Long {
        return withContext(Dispatchers.IO) {
            dao.insert(ref)
        }
    }

    override suspend fun update(ref: BlogPostTagJoin): Int {
        return withContext(Dispatchers.IO) {
            dao.update(ref)
        }
    }

    override suspend fun delete(ref: BlogPostTagJoin) {

        return withContext(Dispatchers.IO) {
            dao.delete(ref)
        }
    }
}