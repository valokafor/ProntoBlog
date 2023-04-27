package com.valokafor.prontoblog.app

import android.content.Context
import com.valokafor.prontoblog.database.dao.*
import com.valokafor.prontoblog.database.repository.contract.*
import com.valokafor.prontoblog.database.repository.local.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): ProntoBlogDatabase {
        return ProntoBlogDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideContent(@ApplicationContext context: Context): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideBlogPostDao(db: ProntoBlogDatabase): BlogPostDao {
        return db.blogPostDao()
    }

    @Singleton
    @Provides
    fun provideCategoryDao(db: ProntoBlogDatabase): CategoryDao {
        return db.categoryDao()
    }

    @Singleton
    @Provides
    fun provideAuthorDao(db: ProntoBlogDatabase): AuthorDao {
        return db.authorDao()
    }

    @Singleton
    @Provides
    fun provideTagDao(db: ProntoBlogDatabase): TagDao {
        return db.tagDao()
    }

    @Singleton
    @Provides
    fun provideAttachmentDao(db: ProntoBlogDatabase): AttachmentDao {
        return db.attachmentDao()
    }

    @Singleton
    @Provides
    fun provideBlogTagJoinDao(db: ProntoBlogDatabase): BlogPostTagJoinDao {
        return db.blogTagJoinDao()
    }

    //////*************************Repositories*****************************/

    @Provides
    fun providesBlogPostRepository(blogDao: BlogPostDao): BlogRepository =
        BlogPostRepositoryLocal(blogDao)

    @Provides
    fun providesCategoryRepository(folderDao: CategoryDao): CategoryRepository =
        CategoryRepositoryLocal(folderDao)

    @Provides
    fun providesAuthorRepository(authorDao: AuthorDao): AuthorRepository =
        AuthorRepositoryLocal(authorDao)

    @Provides
    fun providesTagRepository(tagDao: TagDao): TagRepository =
        TagRepositoryLocal(tagDao)

    @Provides
    fun providesAttachmentRepository(attachmentDao: AttachmentDao): AttachmentRepository =
        AttachmentRepositoryLocal(attachmentDao)

    @Provides
    fun provideBlogPostTagRepository(blogTagDao: BlogPostTagJoinDao)
            : BlogPostTagJoinRepository =
        BlogPostTagJoinRepositoryLocal(blogTagDao)
}