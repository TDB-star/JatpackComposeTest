package com.example.jatpackcomposetest.navigation

sealed class Screen(
    val route: String
) {

    object NewsFeed: Screen(ROUTE_NEWS_FEED)
    object Favorite: Screen(ROUTE_FAVORITE)
    object Profile: Screen(ROUTE_PROFILE)
    object Home: Screen(ROUTE_HOME)
    object Comments: Screen(ROUT_COMMENTS)


    private companion object {
        const val ROUTE_HOME = "home" // graph for newsFeed and comments screens
        const val ROUTE_NEWS_FEED = "news_feed"
        const val ROUT_COMMENTS = "comments"
        const val ROUTE_FAVORITE = "favorite"
        const val ROUTE_PROFILE = "profile"
    }
}