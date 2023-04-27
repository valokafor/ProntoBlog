package com.valokafor.prontoblog.model

data class Category(
    val id: String = "",
    val name: String = "",
    val posts: List<BlogPost> = emptyList(),
    val createAt: Long = System.currentTimeMillis(),
)
