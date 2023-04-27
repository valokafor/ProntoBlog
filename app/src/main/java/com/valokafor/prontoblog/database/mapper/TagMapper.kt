package com.valokafor.prontoblog.database.mapper

import com.valokafor.prontoblog.database.entity.TagEntity
import com.valokafor.prontoblog.model.Tags

object TagMapper: Mapper<TagEntity, Tags> {
    override fun mapToEntity(domain: Tags): TagEntity {
        return TagEntity(
            id = domain.id,
            name = domain.name,
            createAt = domain.createAt
        )
    }

    override fun mapFromEntity(entity: TagEntity): Tags {
        return Tags(
            id = entity.id,
            name = entity.name,
            createAt = entity.createAt
        )
    }

    override fun mapToEntityList(domainList: List<Tags>): List<TagEntity> {
        val result = mutableListOf<TagEntity>()
        domainList.forEach { domain ->
            result.add(mapToEntity(domain))
        }
        return result
    }

    override fun mapToDomainList(entityList: List<TagEntity>): List<Tags> {
        val result = mutableListOf<Tags>()
        entityList.forEach { entity ->
            result.add(mapFromEntity(entity))
        }
        return result
    }
}