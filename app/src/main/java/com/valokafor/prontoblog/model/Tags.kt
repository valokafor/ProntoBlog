package com.valokafor.prontoblog.model

data class Tags(
    val id: String = "",
    val name: String = "",
    val posts: List<BlogPost> = emptyList(),
    val createAt: Long = System.currentTimeMillis()
)
