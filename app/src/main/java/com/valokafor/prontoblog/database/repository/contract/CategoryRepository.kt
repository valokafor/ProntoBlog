package com.valokafor.prontoblog.database.repository.contract

import com.valokafor.prontoblog.database.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getAllCategories(): Flow<List<CategoryEntity>>
    suspend fun getCategoryById(categoryId: String): CategoryEntity?
    fun getCategoryByIdFlow(categoryId: String): Flow<CategoryEntity>
    suspend fun insert(category: CategoryEntity): Long
    suspend fun update(category: CategoryEntity): Int
    suspend fun delete(category: CategoryEntity)
}