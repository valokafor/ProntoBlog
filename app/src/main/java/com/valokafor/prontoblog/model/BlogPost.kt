package com.valokafor.prontoblog.model

import android.graphics.Paint.Style

data class BlogPost(
    val id: String = "",
    val title: String = "",
    val content: String = "",
    val authorId: String = "",
    val author: Author = Author(),
    val categoryId: String = "",
    val category: Category = Category(),
    val tags: List<Tags> = emptyList(),
    val attachments: List<Attachment> = emptyList(),
    val createAt: Long = System.currentTimeMillis(),
    val modifiedAt: Long = System.currentTimeMillis()
)
