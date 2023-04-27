package com.valokafor.prontoblog.database.dao

import androidx.room.*
import com.valokafor.prontoblog.database.entity.BlogPostTagJoin
import kotlinx.coroutines.flow.Flow

@Dao
interface BlogPostTagJoinDao {
    @Query("SELECT * FROM blog_post_tag_join WHERE blogPostId LIKE :id")
    fun getBlogPostRefs(id: String): Flow<List<BlogPostTagJoin>>

    @Query("SELECT * FROM blog_post_tag_join WHERE tagId LIKE :id")
    fun getTagRefs(id: String): Flow<List<BlogPostTagJoin>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ref: BlogPostTagJoin): Long

    @Update
    suspend fun update(ref: BlogPostTagJoin): Int

    @Delete
    suspend fun delete(ref: BlogPostTagJoin)
}