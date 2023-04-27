package com.valokafor.prontoblog.model

data class Attachment(
    val id: String = "",
    val blogId: String = "",
    val photoName: String = "",
    val photoUrl: String = "",
    val mimeType: String = "",
    val createAt: Long = System.currentTimeMillis()
)
