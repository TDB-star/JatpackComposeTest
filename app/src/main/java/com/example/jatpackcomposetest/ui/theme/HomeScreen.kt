package com.example.jatpackcomposetest.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jatpackcomposetest.MainViewModel
import com.example.jatpackcomposetest.domain.PostComment
import com.example.jatpackcomposetest.navigation.CommentsScreen

@Composable

fun HomeScreen(viewModel: MainViewModel,
               paddingValues: PaddingValues) {
    val feedPosts = viewModel.feedPosts.observeAsState(listOf())


    if (feedPosts.value.isNotEmpty()) {
        val comments = mutableListOf<PostComment>().apply {
            repeat(7) {
                add(PostComment(id = it)
                )
            }
        }
        CommentsScreen(feedPost = feedPosts.value.get(0), comments = comments)
    }

//    LazyColumn(
//        modifier = Modifier.padding(paddingValues),
//        contentPadding = PaddingValues(
//            top = 16.dp,
//            start = 8.dp,
//            end = 8.dp,
//            bottom = 8.dp
//        ),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(feedPosts.value,
//            key = {it.id}
//        ) { feedPost ->
//            PostCard(
//                feedPost = feedPost,
//                onViewsClickListener = { interactionsItem ->
//                    viewModel.updateCount(feedPost, interactionsItem)
//                },
//                onShareClickListener = { interactionsItem ->
//                    viewModel.updateCount(feedPost, interactionsItem)
//                },
//                onCommentClickListener = { interactionsItem ->
//                    viewModel.updateCount(feedPost, interactionsItem)
//                },
//                onLikeClickListener = { interactionsItem ->
//                    viewModel.updateCount(feedPost, interactionsItem)
//                }
//            )
//        }
//    }
}