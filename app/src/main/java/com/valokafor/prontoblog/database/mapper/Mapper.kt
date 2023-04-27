package com.valokafor.prontoblog.database.mapper

interface Mapper<E, D> {
    fun mapToEntity(domain: D) : E
    fun mapFromEntity(entity: E): D
    fun mapToEntityList(domainList: List<D>): List<E>
    fun mapToDomainList(entityList: List<E>): List<D>
}