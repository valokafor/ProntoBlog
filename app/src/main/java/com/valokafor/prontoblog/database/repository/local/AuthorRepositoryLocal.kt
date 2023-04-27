package com.valokafor.prontoblog.database.repository.local

import com.valokafor.prontoblog.database.dao.AuthorDao
import com.valokafor.prontoblog.database.entity.AuthorEntity
import com.valokafor.prontoblog.database.repository.contract.AuthorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthorRepositoryLocal @Inject constructor(private val dao: AuthorDao): AuthorRepository {
    override fun getAllAuthors(): Flow<List<AuthorEntity>> {
        return dao.getAuthors()
    }

    override suspend fun getAuthorById(folderId: String): AuthorEntity? {
        return withContext(Dispatchers.IO) {
            dao.getAuthorById(folderId)
        }
    }

    override fun getAuthorByIdFlow(folderId: String): Flow<AuthorEntity> {
        return dao.getAuthorByIdFlow(folderId)
    }

    override suspend fun insert(author: AuthorEntity): Long {
        return withContext(Dispatchers.IO) {
            dao.insert(author)
        }
    }

    override suspend fun update(author: AuthorEntity): Int {
        return withContext(Dispatchers.IO) {
            dao.update(author)
        }
    }

    override suspend fun delete(author: AuthorEntity) {
        return withContext(Dispatchers.IO) {
            dao.delete(author)
        }
    }
}