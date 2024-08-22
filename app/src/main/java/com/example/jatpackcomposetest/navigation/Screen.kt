package com.example.jatpackcomposetest.navigation

import com.example.jatpackcomposetest.domain.FeedPost

sealed class Screen(
    val route: String
) {

    object NewsFeed: Screen(ROUTE_NEWS_FEED)
    object Favorite: Screen(ROUTE_FAVORITE)
    object Profile: Screen(ROUTE_PROFILE)
    object Home: Screen(ROUTE_HOME)

    object Comments: Screen(ROUT_COMMENTS) {

        private const val ROUT_FOR_ARGS = "comments"

        fun getRouteWithArgs(feedPost: FeedPost): String {
            return "$ROUT_FOR_ARGS/${feedPost.id}/${feedPost.postText}"
        }
    }


    companion object {

        const val KEY_FEED_POST_ID = "feed_post_id"
        const val KEY_FEED_POST_TEXT = "feed_post_text"

        const val ROUTE_HOME = "home" // graph for newsFeed and comments screens
        const val ROUTE_NEWS_FEED = "news_feed"
        const val ROUT_COMMENTS = "comments/{$KEY_FEED_POST_ID}/{$KEY_FEED_POST_TEXT}" // route to retrieve args
        const val ROUTE_FAVORITE = "favorite"
        const val ROUTE_PROFILE = "profile"
    }
}