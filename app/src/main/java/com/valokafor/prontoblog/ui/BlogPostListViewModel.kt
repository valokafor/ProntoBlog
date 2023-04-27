package com.valokafor.prontoblog.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valokafor.prontoblog.model.BlogPost
import com.valokafor.prontoblog.model.usecases.GetJournalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlogPostListViewModel @Inject constructor(
    private val getJournalUseCase: GetJournalUseCase) : ViewModel() {

    var currentBlogPost = mutableStateOf(BlogPost())
    fun getBlogPostList(): Flow<List<BlogPost>> = getJournalUseCase.getAllBlogPosts()

    fun getCurrentBlogPost(blogPostId: String) {
        viewModelScope.launch {
            getJournalUseCase.getJournalById(blogPostId).collectLatest { blogPost ->
                currentBlogPost.value = blogPost
            }
        }
    }
}