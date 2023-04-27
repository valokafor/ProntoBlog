package com.valokafor.prontoblog.database.mapper


import com.valokafor.prontoblog.database.entity.AttachmentEntity
import com.valokafor.prontoblog.model.Attachment

object AttachmentMapper: Mapper<AttachmentEntity, Attachment> {
    override fun mapToEntity(domain: Attachment): AttachmentEntity {
        return AttachmentEntity(
            id = domain.id,
            blogPostId = domain.blogId,
            photoName = domain.photoName,
            photoUrl = domain.photoUrl,
            mimeType = domain.mimeType,
            createAt = domain.createAt
        )
    }

    override fun mapFromEntity(entity: AttachmentEntity): Attachment {
        return Attachment(
            id = entity.id,
            blogId = entity.blogPostId,
            photoName = entity.photoName,
            photoUrl = entity.photoUrl,
            mimeType = entity.mimeType,
            createAt = entity.createAt
        )
    }

    override fun mapToEntityList(domainList: List<Attachment>): List<AttachmentEntity> {
        val result = mutableListOf<AttachmentEntity>()
        domainList.forEach { domain ->
            result.add(mapToEntity(domain))
        }
        return result
    }

    override fun mapToDomainList(entityList: List<AttachmentEntity>): List<Attachment> {
        val result = mutableListOf<Attachment>()
        entityList.forEach { entity ->
            result.add(mapFromEntity(entity))
        }
        return result
    }
}