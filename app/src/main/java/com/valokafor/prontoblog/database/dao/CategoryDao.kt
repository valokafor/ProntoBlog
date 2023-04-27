package com.valokafor.prontoblog.database.dao

import androidx.room.*
import com.valokafor.prontoblog.database.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category ORDER BY createAt DESC")
    fun getCategories(): Flow<List<CategoryEntity>>

    @Query("SELECT * FROM category WHERE id LIKE :id LIMIT 1")
    suspend fun findCategoryById(id: String): CategoryEntity?

    @Query("SELECT * FROM category WHERE id LIKE :id LIMIT 1")
    fun findCategoryByIdFlow(id: String): Flow<CategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(folder: CategoryEntity): Long

    @Update
    suspend fun update(folder: CategoryEntity): Int

    @Delete
    suspend fun delete(folder: CategoryEntity)

}