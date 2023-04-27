package com.valokafor.prontoblog.database.mapper

import com.valokafor.prontoblog.database.entity.AuthorEntity
import com.valokafor.prontoblog.model.Author

object AuthorMapper : Mapper<AuthorEntity, Author> {
    override fun mapToEntity(domain: Author): AuthorEntity {
        return AuthorEntity(
            id = domain.id,
            name = domain.name,
            createAt = domain.createAt
        )
    }

    override fun mapFromEntity(entity: AuthorEntity): Author {
        return Author(
            id = entity.id,
            name = entity.name,
            createAt = entity.createAt
        )
    }

    override fun mapToEntityList(domainList: List<Author>): List<AuthorEntity> {
        val result = mutableListOf<AuthorEntity>()
        domainList.forEach { domain ->
            result.add(mapToEntity(domain))
        }
        return result
    }

    override fun mapToDomainList(entityList: List<AuthorEntity>): List<Author> {
        val result = mutableListOf<Author>()
        entityList.forEach { entity ->
            result.add(mapFromEntity(entity))
        }
        return result
    }
}