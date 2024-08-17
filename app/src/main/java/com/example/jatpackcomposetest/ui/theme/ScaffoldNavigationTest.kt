package com.example.jatpackcomposetest.ui.theme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ScaffoldTest() {
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerItem(
                    label = { Text(text = "Home") },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.Person, contentDescription = null) },
                    onClick = { },
                )
                NavigationDrawerItem(
                    label = { Text(text = "Home") },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.Person, contentDescription = null) },
                    onClick = { },
                )
                NavigationDrawerItem(
                    label = { Text(text = "Home") },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.Person, contentDescription = null) },
                    onClick = { },
                )
                NavigationDrawerItem(
                    label = { Text(text = "Home") },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.Person, contentDescription = null) },
                    onClick = { },
                )
            }
        }
    )
    {     Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "TopAppBar title") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(selected = true, onClick = { }, icon = {
                    Icon(Icons.Filled.Home, contentDescription = null)
                }, label = {
                    Text(text = "Home")
                })

                NavigationBarItem(selected = false, onClick = { }, icon = {
                    Icon(Icons.Filled.Menu, contentDescription = null)
                }, label = {
                    Text(text = "List")
                })
                NavigationBarItem(selected = false, onClick = { }, icon = {
                    Icon(Icons.Filled.Favorite, contentDescription = null)
                }, label = {
                    Text(text = "Favorite")
                })
                NavigationBarItem(selected = false, onClick = { }, icon = {
                    Icon(Icons.Filled.Person, contentDescription = null)
                }, label = {
                    Text(text = "Profile")
                })
            }
        },

        )
    {
        Text(
            modifier = Modifier.padding(it),
            text = "This is scaffold content"
        )
    }
    }}
