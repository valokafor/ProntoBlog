package com.valokafor.prontoblog.model

data class Author(
    val id: String = "",
    val name: String = "",
    val profilePhotoUrl: String = "",
    val posts: List<BlogPost> = emptyList(),
    val createAt: Long = System.currentTimeMillis()
)
