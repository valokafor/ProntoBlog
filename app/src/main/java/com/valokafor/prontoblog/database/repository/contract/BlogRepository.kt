package com.valokafor.prontoblog.database.repository.contract

import com.valokafor.prontoblog.database.entity.BlogPostEntity
import kotlinx.coroutines.flow.Flow

interface BlogRepository {
    fun getAllBlogPosts(): Flow<List<BlogPostEntity>>
    suspend fun getBlogPostById(blogPostId: String): BlogPostEntity?
    fun getBlogPostByIdFlow(blogPostId: String): Flow<BlogPostEntity>
    suspend fun insert(blogPost: BlogPostEntity): Long
    suspend fun update(blogPost: BlogPostEntity): Int
    suspend fun delete(blogPost: BlogPostEntity)
}