package com.example.jatpackcomposetest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable

fun AppNavGraph(
    navController: NavHostController,
    homeScreenContent: @Composable () -> Unit,
    favoriteScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.NewsFeed.rout
    )
    { //navGraphBuilder ->
        composable(Screen.NewsFeed.rout) {
            homeScreenContent()
        }

        composable(Screen.Favorite.rout) {
            favoriteScreenContent()
        }

        composable(Screen.Profile.rout) {
            profileScreenContent()
        }
    }
}