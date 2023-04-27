package com.valokafor.prontoblog.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.valokafor.prontoblog.model.BlogPost

@Entity(tableName = "author")
data class AuthorEntity(
    @PrimaryKey
    val id: String = "",
    val name: String = "",
    val profilePhotoUrl: String = "",
    val createAt: Long = System.currentTimeMillis()
)
