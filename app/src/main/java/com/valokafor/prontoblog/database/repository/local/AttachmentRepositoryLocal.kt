package com.valokafor.prontoblog.database.repository.local

import com.valokafor.prontoblog.database.dao.AttachmentDao
import com.valokafor.prontoblog.database.entity.AttachmentEntity
import com.valokafor.prontoblog.database.repository.contract.AttachmentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AttachmentRepositoryLocal @Inject constructor(private val dao: AttachmentDao):
    AttachmentRepository {
    override fun getAllAttachments(): Flow<List<AttachmentEntity>> {
        return dao.getAttachments()
    }

    override fun getAllAttachmentsForBlogPost(blogPostId: String): Flow<List<AttachmentEntity>> {
        return dao.getAttachmentsForBlogPost(blogPostId)
    }

    override suspend fun getAttachmentById(attachmentId: String): AttachmentEntity? {
        return withContext(Dispatchers.IO) {
            dao.findAttachmentById(attachmentId)
        }
    }

    override fun getAttachmentByIdFlow(attachmentId: String): Flow<AttachmentEntity> {
        return dao.findAttachmentByIdFlow(attachmentId)
    }

    override suspend fun insert(attachment: AttachmentEntity): Long {
        return withContext(Dispatchers.IO) {
            dao.insert(attachment)
        }
    }

    override suspend fun update(attachment: AttachmentEntity): Int {
        return withContext(Dispatchers.IO) {
            dao.update(attachment)
        }
    }

    override suspend fun delete(attachment: AttachmentEntity) {
        return withContext(Dispatchers.IO) {
            dao.delete(attachment)
        }
    }
}