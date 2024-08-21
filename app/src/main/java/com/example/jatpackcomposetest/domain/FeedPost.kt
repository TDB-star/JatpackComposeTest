package com.example.jatpackcomposetest.domain

import com.example.jatpackcomposetest.R

data class FeedPost(
    val id: Int = 0,
    val name: String = "dev/null",
    val time: String = "14:00",
    val avatarResId: Int = R.drawable.giorgio_encinas,
    val postText: String = "Scaffold padding values define padding that will be applied along the inside edges of a box.",
    val contentImage: Int = R.drawable.post,
    val interactions: List<InteractionsItem> = listOf(
        InteractionsItem(type = InteractionsType.VIEWS, count = 966),
        InteractionsItem(type = InteractionsType.SHARES, count = 7),
        InteractionsItem(type = InteractionsType.COMMENTS, count = 9),
        InteractionsItem(type = InteractionsType.LIKES, count = 54)
    )
)