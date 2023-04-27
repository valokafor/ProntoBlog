package com.valokafor.prontoblog.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tags")
data class TagEntity(
    @PrimaryKey
    val id: String = "",
    val name: String = "",
    val createAt: Long = System.currentTimeMillis()
)
