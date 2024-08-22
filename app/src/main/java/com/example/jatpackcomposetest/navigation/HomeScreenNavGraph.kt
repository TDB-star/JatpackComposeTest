package com.example.jatpackcomposetest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.jatpackcomposetest.domain.FeedPost

fun NavGraphBuilder.homeScreenNavGraph(
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (FeedPost) -> Unit
) {
    navigation(
        startDestination = Screen.NewsFeed.route,
        route = Screen.Home.route
    ) {
        composable(Screen.NewsFeed.route) {
            newsFeedScreenContent()
        }
        composable(
            route = Screen.Comments.route,
            arguments = listOf(
                navArgument(Screen.KEY_FEED_POST_ID) {
                    type = NavType.IntType
                },
                navArgument(Screen.KEY_FEED_POST_TEXT) {
                    type = NavType.StringType
                }
            )
        ) {
            val feedPostId = it.arguments?.getInt(Screen.KEY_FEED_POST_ID)
                ?: 0// key to retrieve data //comments/{key}
            val feedPostText = it.arguments?.getString(Screen.KEY_FEED_POST_TEXT) ?: ""
            commentsScreenContent(
                FeedPost(
                    id = feedPostId,
                    postText = feedPostText)
            )
        }
    }
}