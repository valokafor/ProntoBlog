package com.valokafor.prontoblog.database.repository.local

import com.valokafor.prontoblog.database.dao.BlogPostDao
import com.valokafor.prontoblog.database.entity.BlogPostEntity
import com.valokafor.prontoblog.database.repository.contract.BlogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BlogPostRepositoryLocal @Inject constructor(private val dao: BlogPostDao): BlogRepository {
    override fun getAllBlogPosts(): Flow<List<BlogPostEntity>> {
        return dao.getAllBlogPosts()
    }

    override suspend fun getBlogPostById(blogPostId: String): BlogPostEntity? {
        return dao.findBlogPostById(blogPostId)
    }

    override fun getBlogPostByIdFlow(blogPostId: String): Flow<BlogPostEntity> {
        return dao.findBlogPostByIdFlow(blogPostId)
    }

    override suspend fun insert(blogPost: BlogPostEntity): Long {
        return withContext(Dispatchers.IO) {
            dao.insert(blogPost)
        }
    }

    override suspend fun update(blogPost: BlogPostEntity): Int {
        return withContext(Dispatchers.IO) {
            dao.update(blogPost)
        }
    }

    override suspend fun delete(blogPost: BlogPostEntity) {
        return withContext(Dispatchers.IO) {
            dao.delete(blogPost)
        }
    }
}