package com.valokafor.prontoblog.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.valokafor.prontoblog.database.dao.*
import com.valokafor.prontoblog.database.entity.*


@Database(
    entities = [
        BlogPostEntity::class,
        AttachmentEntity::class,
        CategoryEntity::class,
        AuthorEntity::class,
        TagEntity::class,
        BlogPostTagJoin::class
    ],
    version = 1,
    exportSchema = true
)

abstract class ProntoBlogDatabase : RoomDatabase() {
    abstract fun blogPostDao(): BlogPostDao
    abstract fun tagDao(): TagDao
    abstract fun attachmentDao(): AttachmentDao
    abstract fun categoryDao(): CategoryDao
    abstract fun authorDao(): AuthorDao
    abstract fun blogTagJoinDao(): BlogPostTagJoinDao

    companion object {

        @Volatile
        private var INSTANCE: ProntoBlogDatabase? = null

        fun getInstance(context: Context): ProntoBlogDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ProntoBlogDatabase::class.java, "pronto_blog_post.db"
            )
                .fallbackToDestructiveMigration()
                .build()

    }
}
