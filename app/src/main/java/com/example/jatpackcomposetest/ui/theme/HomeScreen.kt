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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jatpackcomposetest.NewsFeedViewModel
import com.example.jatpackcomposetest.domain.FeedPost

@Composable

fun HomeScreen(
    paddingValues: PaddingValues,
    onCommentClickListener: (FeedPost) -> Unit
) {
    //val viewModel = ViewModelProvider(LocalViewModelStoreOwner.current!!)[NewsFeedViewModel::class.java]
    val viewModel: NewsFeedViewModel = viewModel()
    val screenState = viewModel.screenState.observeAsState(NewsFeedScreenState.Initial)

    when (val currentState = screenState.value) {
        is NewsFeedScreenState.Posts -> {
            FeedPosts(
                viewModel = viewModel,
                paddingValues = paddingValues,
                posts = currentState.posts,
                onCommentClickListener = onCommentClickListener
            )
        }

        NewsFeedScreenState.Initial -> {}
    }
}

@Composable
private fun FeedPosts(
    viewModel: NewsFeedViewModel,
    paddingValues: PaddingValues,
    posts: List<FeedPost>,
    onCommentClickListener: (FeedPost) -> Unit
) {
    LazyColumn(
        modifier = Modifier.padding(paddingValues),
        contentPadding = PaddingValues(
            top = 16.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 8.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(posts,
            key = {it.id}
        ) { feedPost ->
            PostCard(
                feedPost = feedPost,
                onViewsClickListener = { interactionsItem ->
                    viewModel.updateCount(feedPost, interactionsItem)
                },
                onShareClickListener = { interactionsItem ->
                    viewModel.updateCount(feedPost, interactionsItem)
                },
                onCommentClickListener = { interactionsItem ->
                    onCommentClickListener(feedPost)
                },
                onLikeClickListener = { interactionsItem ->
                    viewModel.updateCount(feedPost, interactionsItem)
                }
            )
        }
    }
}