package com.example.jatpackcomposetest.ui.theme

import com.example.jatpackcomposetest.domain.FeedPost
import com.example.jatpackcomposetest.domain.PostComment

sealed class CommentsScreenState {

    object Initial: CommentsScreenState()

    data class Comments (
        val post: FeedPost,
        val comments: List<PostComment>
    ): CommentsScreenState()
}