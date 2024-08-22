package com.example.jatpackcomposetest.ui.theme


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jatpackcomposetest.domain.FeedPost
import com.example.jatpackcomposetest.navigation.AppNavGraph
import com.example.jatpackcomposetest.navigation.NavigationItem
import com.example.jatpackcomposetest.navigation.rememberNavState

@Composable
fun MainScreen(

) {

    val navigationState = rememberNavState()
    val commentsToPost: MutableState<FeedPost?> = remember {
        mutableStateOf(null)
    }

    Scaffold(bottomBar = {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.primary
        ) {

            val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()

            val items = listOf(
                NavigationItem.Home,
                NavigationItem.Favorite,
                NavigationItem.Profile
            )
            items.forEach { item ->

                val selected = navBackStackEntry?.destination?.hierarchy?.any {
                    it.route == item.screen.route
                } ?: false

                NavigationBarItem(
                    selected = selected,
                    onClick = {
                        if (!selected) {
                            navigationState.navigateTo(item.screen.route)
                        }
                    },
                    icon = { Icon(imageVector = item.icon, contentDescription = null) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                        unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                        indicatorColor = MaterialTheme.colorScheme.primary
                    ),
                    label = {
                        Text(text = stringResource(id = item.titleResId))
                    })
            }
        }
    }) { paddingValues ->
        AppNavGraph(
            navController = navigationState.navHostController,

            newsFeedScreenContent = {
                HomeScreen(
                    paddingValues = paddingValues,
                    onCommentClickListener = {
                        commentsToPost.value = it
                        navigationState.navigateToComments()
                    }
                )
            },
            commentsScreenContent = {
                CommentsScreen(
                    onBackPressed = { navigationState.navHostController.popBackStack() },
                    feedPost = commentsToPost.value!!
                )
            },

            favoriteScreenContent = {
                Box(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(20.dp)
                ) {
                    Text(text = "Favorites")
                }
            },
            profileScreenContent = {
                Box(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(20.dp)
                ) {
                    Text(text = "Profile")
                }
            }
        )
    }
}