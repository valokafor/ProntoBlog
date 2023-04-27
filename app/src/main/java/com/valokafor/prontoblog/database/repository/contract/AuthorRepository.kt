package com.valokafor.prontoblog.database.repository.contract

import com.valokafor.prontoblog.database.entity.AuthorEntity
import com.valokafor.prontoblog.database.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

interface AuthorRepository {
    fun getAllAuthors(): Flow<List<AuthorEntity>>
    suspend fun getAuthorById(authorId: String): AuthorEntity?
    fun getAuthorByIdFlow(authorId: String): Flow<AuthorEntity>
    suspend fun insert(author: AuthorEntity): Long
    suspend fun update(author: AuthorEntity): Int
    suspend fun delete(author: AuthorEntity)
}