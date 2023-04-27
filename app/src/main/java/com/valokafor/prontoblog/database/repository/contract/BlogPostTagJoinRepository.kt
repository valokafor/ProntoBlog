package com.valokafor.prontoblog.database.repository.contract

import com.valokafor.prontoblog.database.entity.BlogPostTagJoin
import kotlinx.coroutines.flow.Flow

interface BlogPostTagJoinRepository {
    fun getBlogPostRefs(blogPostId: String): Flow<List<BlogPostTagJoin>>
    fun getTagRefs(tagId: String): Flow<List<BlogPostTagJoin>>
    suspend fun insert(ref: BlogPostTagJoin): Long
    suspend fun update(ref: BlogPostTagJoin): Int
    suspend fun delete(ref: BlogPostTagJoin)
}