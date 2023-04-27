package com.valokafor.prontoblog.database.entity

import android.graphics.Paint.Style
import androidx.room.Entity
import com.valokafor.prontoblog.model.Attachment
import com.valokafor.prontoblog.model.Author
import com.valokafor.prontoblog.model.Tags

@Entity(tableName = "blog_post")
data class BlogPostEntity(
    val id: String = "",
    val title: String = "",
    val content: String = "",
    val categoryId: String = "",
    val authorId: String = "",
    val createAt: Long = System.currentTimeMillis(),
    val modifiedAt: Long = System.currentTimeMillis()
)
