package com.example.jatpackcomposetest.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.jatpackcomposetest.R

sealed class NavigationItem(
    val titleResId: Int,
    val icon: ImageVector
) {


    object Home: NavigationItem(
        titleResId = R.string.navigation_item_home,
        icon = Icons.Rounded.Home
    )

    object Favorite: NavigationItem(
        titleResId = R.string.navigation_item_favorite,
        icon = Icons.Rounded.Favorite
    )

    object Profile: NavigationItem(
        titleResId = R.string.navigation_item_profile,
        icon = Icons.Rounded.Person
    )
}