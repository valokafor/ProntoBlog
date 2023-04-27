package com.valokafor.prontoblog.database.entity

import androidx.room.Entity

@Entity(tableName = "blog_post_tag_join", primaryKeys = ["blogPostId", "tagId"])
data class BlogPostTagJoin(
    val blogPostId: String,
    val tagId: String
)