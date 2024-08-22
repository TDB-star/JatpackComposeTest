package com.example.jatpackcomposetest.ui.theme

import com.example.jatpackcomposetest.domain.FeedPost

sealed class NewsFeedScreenState {

    object Initial: NewsFeedScreenState()

    data class Posts(val posts: List<FeedPost>): NewsFeedScreenState()
}