package com.example.jatpackcomposetest.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.jatpackcomposetest.R

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val icon: ImageVector
) {

    object Home: NavigationItem(
        screen = Screen.Home,
        titleResId = R.string.navigation_item_home,
        icon = Icons.Rounded.Home
    )

    object Favorite: NavigationItem(
        screen = Screen.Favorite,
        titleResId = R.string.navigation_item_favorite,
        icon = Icons.Rounded.Favorite
    )

    object Profile: NavigationItem(
        screen = Screen.Profile,
        titleResId = R.string.navigation_item_profile,
        icon = Icons.Rounded.Person
    )
}