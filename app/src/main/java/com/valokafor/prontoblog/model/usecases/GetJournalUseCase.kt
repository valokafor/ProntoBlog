package com.valokafor.prontoblog.model.usecases

import com.valokafor.prontoblog.database.entity.*
import com.valokafor.prontoblog.database.mapper.BlogPostMapper
import com.valokafor.prontoblog.database.repository.contract.*
import com.valokafor.prontoblog.model.BlogPost
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject


@OptIn(ExperimentalCoroutinesApi::class)
class GetJournalUseCase @Inject constructor(
    private val repository: BlogRepository,
    private val categoryRepository: CategoryRepository,
    private val authorRepository: AuthorRepository,
    private val tagRepository: TagRepository,
    private val blogTagJoin: BlogPostTagJoinRepository,
    private val attachmentRepository: AttachmentRepository
){
    fun getJournalById(blogPostId: String): Flow<BlogPost> {
        return repository.getBlogPostByIdFlow(blogPostId)
            .flatMapLatest { blogPostEntity: BlogPostEntity ->
                attachmentRepository.getAllAttachmentsForBlogPost(blogPostId)
                    .flatMapLatest { attachmentList: List<AttachmentEntity> ->
                        categoryRepository.getCategoryByIdFlow(blogPostEntity.categoryId)
                            .flatMapLatest { categoryEntity: CategoryEntity ->
                                authorRepository.getAuthorByIdFlow(blogPostEntity.authorId)
                                    .flatMapLatest { authorEntity: AuthorEntity ->
                                        blogTagJoin.getBlogPostRefs(blogPostId)
                                            .flatMapLatest { references: List<BlogPostTagJoin> ->
                                                tagRepository.getAllTags(references.map {
                                                        ref -> ref.blogPostId }.toTypedArray())
                                                    .map { tags: List<TagEntity> ->
                                                        BlogPostMapper
                                                            .mapRelatedEntitiesToDomain(
                                                            blogPostEntity,
                                                            categoryEntity,
                                                            authorEntity,
                                                            attachmentList,
                                                            tags
                                                        )
                                                    }
                                            }
                                    }
                            }
                    }
            }
    }

    fun getAllBlogPosts(): Flow<List<BlogPost>> {
        return repository.getAllBlogPosts().mapLatest {entityList ->
            mapListOfEntitiesToDomainList(entityList)
        }
    }

    private suspend fun mapListOfEntitiesToDomainList(entityList: List<BlogPostEntity>): List<BlogPost> {
        //Todo - implement as you see fit
        return emptyList()
    }

}