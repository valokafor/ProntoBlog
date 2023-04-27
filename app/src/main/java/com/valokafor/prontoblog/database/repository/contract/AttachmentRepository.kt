package com.valokafor.prontoblog.database.repository.contract

import com.valokafor.prontoblog.database.entity.AttachmentEntity
import kotlinx.coroutines.flow.Flow

interface AttachmentRepository {
    fun getAllAttachments(): Flow<List<AttachmentEntity>>
    fun getAllAttachmentsForBlogPost(blogPostId: String): Flow<List<AttachmentEntity>>
    suspend fun getAttachmentById(attachmentId: String): AttachmentEntity?
    fun getAttachmentByIdFlow(attachmentId: String): Flow<AttachmentEntity>
    suspend fun insert(attachment: AttachmentEntity): Long
    suspend fun update(attachment: AttachmentEntity): Int
    suspend fun delete(attachment: AttachmentEntity)
}