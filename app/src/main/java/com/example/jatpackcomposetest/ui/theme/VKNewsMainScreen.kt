package com.example.jatpackcomposetest.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jatpackcomposetest.R
import com.example.jatpackcomposetest.domain.FeedPost

@Preview
@Composable
fun MainScreen() {

    val feedPost = remember {
        mutableStateOf(FeedPost())
    }

    Scaffold(bottomBar = {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.primary
        ) {

            val selectedItem = remember {
                mutableStateOf(0)
            }
            val items = listOf(
                NavigationItem.Home,
                NavigationItem.Favorite,
                NavigationItem.Profile
            )
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItem.value == index,
                    onClick = {selectedItem.value = index },
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
        PostCard(
            modifier = Modifier.padding(paddingValues),
            feedPost = feedPost.value,
            onInteractionsItemClickListener = { newItem ->
                val oldInteractions = feedPost.value.interactions
                val newInteractions = oldInteractions.toMutableList().apply {
                    replaceAll { oldItem ->
                        if (oldItem.type == newItem.type) {
                            oldItem.copy(count = oldItem.count + 1)
                        } else {
                            oldItem
                        }
                    }
                }
                feedPost.value = feedPost.value.copy(interactions = newInteractions)
            }
        )
    }
}