package com.valokafor.prontoblog.database.entity

import androidx.room.Entity

@Entity(tableName = "category")
data class CategoryEntity(
    val id: String = "",
    val name: String = "",
    val createAt: Long = System.currentTimeMillis(),
)
