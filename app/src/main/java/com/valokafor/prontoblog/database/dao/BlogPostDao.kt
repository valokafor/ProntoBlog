package com.valokafor.prontoblog.database.dao

import androidx.room.*
import com.valokafor.prontoblog.database.entity.BlogPostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BlogPostDao {
    @Query("SELECT * FROM blog_post ORDER BY createAt DESC")
    fun getAllBlogPosts(): Flow<List<BlogPostEntity>>

    @Query("SELECT * FROM blog_post WHERE id LIKE :id LIMIT 1")
    suspend fun findBlogPostById(id: String): BlogPostEntity?

    @Query("SELECT * FROM blog_post WHERE id LIKE :id LIMIT 1")
    fun findBlogPostByIdFlow(id: String): Flow<BlogPostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(blogPost: BlogPostEntity): Long

    @Update
    suspend fun update(blogPost: BlogPostEntity): Int

    @Delete
    suspend fun delete(blogPost: BlogPostEntity)

}