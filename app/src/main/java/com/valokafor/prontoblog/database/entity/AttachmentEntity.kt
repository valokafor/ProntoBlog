package com.valokafor.prontoblog.database.entity

import androidx.room.Entity

@Entity(tableName = "attachments")
data class AttachmentEntity(
    val id: String = "",
    val blogPostId: String = "",
    val photoName: String = "",
    val photoUrl: String = "",
    val mimeType: String = "",
    val createAt: Long = System.currentTimeMillis()
)
