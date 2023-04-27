package com.valokafor.prontoblog.database.mapper

import com.valokafor.prontoblog.database.entity.CategoryEntity
import com.valokafor.prontoblog.model.Category

object CategoryMapper : Mapper<CategoryEntity, Category> {
    override fun mapToEntity(domain: Category): CategoryEntity {
        return CategoryEntity(
            id = domain.id,
            name = domain.name,
            createAt = domain.createAt
        )
    }

    override fun mapFromEntity(entity: CategoryEntity): Category {
        return Category(
            id = entity.id,
            name = entity.name,
            createAt = entity.createAt
        )
    }

    override fun mapToEntityList(domainList: List<Category>): List<CategoryEntity> {
        val result = mutableListOf<CategoryEntity>()
        domainList.forEach { domain ->
            result.add(mapToEntity(domain))
        }
        return result
    }

    override fun mapToDomainList(entityList: List<CategoryEntity>): List<Category> {
        val result = mutableListOf<Category>()
        entityList.forEach { entity ->
            result.add(mapFromEntity(entity))
        }
        return result
    }
}