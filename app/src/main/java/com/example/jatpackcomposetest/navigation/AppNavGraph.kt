package com.example.jatpackcomposetest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.jatpackcomposetest.domain.FeedPost

@Composable
fun AppNavGraph(
    navController: NavHostController,
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (FeedPost) -> Unit,
    favoriteScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    )
    { //navGraphBuilder ->

        homeScreenNavGraph(
            newsFeedScreenContent = newsFeedScreenContent,
            commentsScreenContent = commentsScreenContent
        )
        
        composable(Screen.Favorite.route) {
            favoriteScreenContent()
        }

        composable(Screen.Profile.route) {
            profileScreenContent()
        }
    }
}