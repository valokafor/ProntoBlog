package com.valokafor.prontoblog.database.repository.local

import com.valokafor.prontoblog.database.dao.CategoryDao
import com.valokafor.prontoblog.database.entity.CategoryEntity
import com.valokafor.prontoblog.database.repository.contract.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryRepositoryLocal @Inject constructor(private val dao: CategoryDao): CategoryRepository {
    override fun getAllCategories(): Flow<List<CategoryEntity>> {
        return dao.getCategories()
    }

    override suspend fun getCategoryById(folderId: String): CategoryEntity? {
        return withContext(Dispatchers.IO) {
            dao.findCategoryById(folderId)
        }
    }

    override fun getCategoryByIdFlow(folderId: String): Flow<CategoryEntity> {
        return dao.findCategoryByIdFlow(folderId)
    }

    override suspend fun insert(folder: CategoryEntity): Long {
        return withContext(Dispatchers.IO) {
            dao.insert(folder)
        }
    }

    override suspend fun update(folder: CategoryEntity): Int {
        return withContext(Dispatchers.IO) {
            dao.update(folder)
        }
    }

    override suspend fun delete(folder: CategoryEntity) {
        return withContext(Dispatchers.IO) {
            dao.delete(folder)
        }
    }
}