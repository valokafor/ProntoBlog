package com.valokafor.prontoblog.database.mapper

import com.valokafor.prontoblog.database.entity.*
import com.valokafor.prontoblog.model.Author
import com.valokafor.prontoblog.model.BlogPost
import com.valokafor.prontoblog.model.Category

object BlogPostMapper: Mapper<BlogPostEntity, BlogPost> {
    override fun mapToEntity(domain: BlogPost): BlogPostEntity {
        return BlogPostEntity(
            id = domain.id,
            title = domain.title,
            content = domain.content,
            categoryId = domain.category.id,
            createAt = domain.createAt,
            modifiedAt = domain.modifiedAt
        )
    }

    override fun mapFromEntity(entity: BlogPostEntity): BlogPost {
        return BlogPost(
            id = entity.id,
            title = entity.title,
            content = entity.content,
            categoryId = entity.categoryId,
            authorId = entity.authorId,
            author = Author(),
            category = Category(),
            createAt = entity.createAt,
            modifiedAt = entity.modifiedAt,
        )
    }

    override fun mapToEntityList(domainList: List<BlogPost>): List<BlogPostEntity> {
        val result = mutableListOf<BlogPostEntity>()
        domainList.forEach { domain ->
            result.add(mapToEntity(domain))
        }
        return result
    }

    override fun mapToDomainList(entityList: List<BlogPostEntity>): List<BlogPost> {
        val result = mutableListOf<BlogPost>()
        entityList.forEach { entity ->
            result.add(mapFromEntity(entity))
        }
        return result
    }

    fun mapRelatedEntitiesToDomain(
        entity: BlogPostEntity,
        categoryEntity: CategoryEntity,
        authorEntity: AuthorEntity,
        attachments: List<AttachmentEntity>,
        tags: List<TagEntity>
    ): BlogPost {
        val journal = mapFromEntity(entity)
        return journal.copy(
            author = AuthorMapper.mapFromEntity(authorEntity),
            category = CategoryMapper.mapFromEntity(categoryEntity),
            attachments = AttachmentMapper.mapToDomainList(attachments),
            tags = TagMapper.mapToDomainList(tags)
        )
    }
}