package com.valokafor.prontoblog.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.valokafor.prontoblog.model.BlogPost

@Composable
fun BlogPostList(viewModel: BlogPostListViewModel) {
    val blogList by viewModel.getBlogPostList().collectAsState(initial = emptyList())

    Scaffold() { innerPadding ->
        Column(modifier = Modifier.padding(16.dp)) {
            LazyColumn(contentPadding = innerPadding) {
                items(blogList) { post: BlogPost ->
                    BlogListCard(blogPost = post)
                }
            }
        }
    }
}