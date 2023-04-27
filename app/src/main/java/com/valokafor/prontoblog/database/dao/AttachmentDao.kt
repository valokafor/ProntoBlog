package com.valokafor.prontoblog.database.dao

import androidx.room.*
import com.valokafor.prontoblog.database.entity.AttachmentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AttachmentDao {
    @Query("SELECT * FROM attachments ORDER BY createAt DESC")
    fun getAttachments(): Flow<List<AttachmentEntity>>

    @Query("SELECT * FROM attachments WHERE journalId=:id ORDER BY createAt DESC")
    fun getAttachmentsForBlogPost(id: String): Flow<List<AttachmentEntity>>

    @Query("SELECT * FROM attachments WHERE id LIKE :id LIMIT 1")
    suspend fun findAttachmentById(id: String): AttachmentEntity?

    @Query("SELECT * FROM attachments WHERE id LIKE :id LIMIT 1")
    fun findAttachmentByIdFlow(id: String): Flow<AttachmentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(attachment: AttachmentEntity): Long

    @Update
    suspend fun update(attachment: AttachmentEntity): Int

    @Delete
    suspend fun delete(attachment: AttachmentEntity)

}